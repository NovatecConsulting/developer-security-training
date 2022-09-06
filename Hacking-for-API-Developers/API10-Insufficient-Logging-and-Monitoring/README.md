# API10: Insufficient Logging and Monitoring

Insufficient logging and monitoring, coupled with missing or ineffective integration with incident response, allows attackers to further attack systems, maintain persistence, pivot to more systems to tamper with, extract, or destroy data. Most breach studies demonstrate the time to detect a breach is over 200 days, typically detected by external parties rather than internal processes or monitoring.

The API is vulnerable if:

* It does not produce any logs, the logging level is not set correctly, or log messages do not include enough detail.
* Log integrity is not guaranteed (e.g., Log Injection).
* Logs are not continuously monitored.
* API infrastructure is not continuously monitored.

## How To Prevent

* Log all failed authentication attempts, denied access, and input validation errors.
* Logs should be written using a format suited to be consumed by a log management solution, and should include enough detail to identify the malicious actor.
* Logs should be handled as sensitive data, and their integrity should be guaranteed at rest and transit.
* Configure a monitoring system to continuously monitor the infrastructure, network, and the API functioning.
* Use a Security Information and Event Management (SIEM) system to aggregate and manage logs from all components of the API stack and hosts.
* Configure custom dashboards and alerts, enabling suspicious activities to be detected and responded to earlier.
