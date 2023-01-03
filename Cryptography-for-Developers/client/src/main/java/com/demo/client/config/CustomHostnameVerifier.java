package com.demo.client.config;

import lombok.extern.slf4j.Slf4j;

import javax.naming.InvalidNameException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;

/**
 * {@code CustomHostnameVerifier} logs server cn and dn.
 */
@Slf4j
@SuppressWarnings({"squid:S1141"})
public class CustomHostnameVerifier implements HostnameVerifier {

    @Override
    public boolean verify(String host, SSLSession session) {
        try {
            Certificate[] certs = session.getPeerCertificates();
            X509Certificate x509 = (X509Certificate) certs[0];
            X500Principal principal = x509.getSubjectX500Principal();

            log.info("server host: " + host);

            String dn = principal.getName("RFC2253");
            log.info("server dn: " + dn);

            if (dn != null) {
                String cn = extractCN(dn);
                log.info("server cn: " + cn);
            }
        } catch (SSLException e) {
            log.debug(e.getMessage(), e);
        }

        return true;
    }

    private static String extractCN(String dnString) throws SSLException {
        try {
            LdapName dn = new LdapName(dnString);
            List<Rdn> rdns = dn.getRdns();

            for (Rdn r : rdns) {
                Attributes attrs = r.toAttributes();
                Attribute cn = attrs.get("cn");
                if (cn != null) {
                    try {
                        Object value = cn.get();
                        if (value != null) {
                            return value.toString();
                        }
                    } catch (Exception e) {
                        log.debug("Errror during cn extraction", e);
                    }
                }
            }
        } catch (InvalidNameException e) {
            throw new SSLException(
                    dnString + " is not a valid X500 distinguished name");
        }

        return null;
    }
}
