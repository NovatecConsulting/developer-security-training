# Hacking for API Developers

In this hacking hands-on training, the most critical risks in APIs are presented to teach backend developers how to develop a secure API.  

API stands for **application programming interface**, which is a set of definitions and protocols for building and integrating application software.

APIs let your product or service communicate with other products and services without having to know how they’re implemented. This can simplify app development, saving time and money. When you’re designing new tools and products—or managing existing ones—APIs give you flexibility; simplify design, administration, and use; and provide opportunities for innovation.

APIs are sometimes thought of as contracts, with documentation that represents an agreement between parties.

## Types of APIs

### Representational State Transfer (REST)

The first and most widely used specification is Representational State Transfer (REST). Web APIs that adhere to the REST architectural constraints are called RESTful APIs. In recent years, the OpenAPI specification has emerged as a common standard for defining REST APIs. REST is an architectural style and therefore there is no official standard for RESTful web APIs. As defined in Roy Fielding’s dissertation [*Architectural Styles and the Design of Network-based Software Architectures*](https://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm), APIs are RESTful as long as they comply with the following guiding constraints of a RESTful system:

* Client-server architecture: REST architecture is composed of clients, servers, and resources, and it handles requests through HTTP.
* Statelessness: No client content is stored on the server between requests. Information about the session state is, instead, held with the client.
* Cacheability: Caching can eliminate the need for some client-server interactions.
* Layered system: Client-server interactions can be mediated by additional layers. These layers could offer additional features like load balancing, shared caches, or security.
* Uniform interface: This constraint is core to the design of RESTful APIs and includes 4 facets:
   * Resource identification in requests: Resources are identified in requests and are separate from the representations returned to the client.

   * Resource manipulation through representations: Clients receive files that represent resources. These representations must have enough information to allow modification or deletion.

   * Self-descriptive messages: Each message returned to a client contains enough information to describe how the client should process the information.

   * Hypermedia as the engine of application state: After accessing a resource, the REST client should be able to discover through hyperlinks all other actions that are currently available.

The [Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html) breaks down the principal elements into different levels.

### GraphQL

Another API standard to emerge is [GraphQL](https://graphql.org/), a query language and server-side runtime that’s an alternative to REST. GraphQL prioritizes giving clients exactly the data they request and no more. As an alternative to REST, GraphQL lets developers construct requests that pull data from multiple data sources in a single API call.
Additionally, GraphQL gives API maintainers the flexibility to add or deprecate fields without impacting existing queries. Developers can build APIs with whatever methods they prefer, and the GraphQL specification will ensure they function in predictable ways to clients.

### gRPC

[gRPC](https://grpc.io/) is a modern open source high performance Remote Procedure Call (RPC) framework that can run in any environment. It can efficiently connect services in and across data centers with pluggable support for load balancing, tracing, health checking and authentication. It is also applicable in last mile of distributed computing to connect devices, mobile applications and browsers to backend services. gRPC was initially created by Google.
By default, gRPC uses [Protocol Buffers](https://developers.google.com/protocol-buffers/docs/overview), Google’s mature open source mechanism for serializing structured data (although it can be used with other data formats such as JSON).

## Setup


### Web Proxy

#### OWASP ZAP

Follow the setup instructions on https://www.zaproxy.org/download/.  

Starting with version 2.8.0, OWASP ZAP includes a _Heads Up Display_. Look into the
corresponding [OWASP ZAP HUD github project](https://github.com/zaproxy/zap-hud) to learn more about this fascinating feature.

### REST API clients

#### Postman

To make calls to REST API of the Juice Shop via a comfortable UI you may use Postman.  
Follow the setup instructions on https://www.postman.com/downloads.

#### Httpie

If you are more used to make calls to REST API of the Juice Shop via command line you may try Httpie.  
Follow the setup instructions on https://httpie.org.

#### Curl

If you are more used to make calls to REST API of the Juice Shop via command line you also may try the classic Curl.  
Follow the setup instructions on https://curl.haxx.se.

### The Challenges

The challenges are categorized according to the [OWASP API Security Top 10 (2019)](https://github.com/OWASP/API-Security) list.

* [API01: Broken Object Level Authorization](API01-Broken-Object-Level-Authorization/README.md)
* [API02: Broken User Authentication](API02-Broken-User-Authentication/README.md)
* [API03: Excessive Data Exposure](API03-Excessive-Data-Exposure/README.md)
* [API04: Lack of Resources and Rate Limiting](API04-Lack-of-Resources-and-Rate-Limiting/README.md)
* [API05: Broken Function Level Authorization](API05-Broken-Function-Level-Authorization/README.md)
* [API06: Mass Assignment](API06-Mass-Assignment/README.md)
* [API07: Security Misconfiguration](API07-Security-Misconfiguration/README.md)
* [API08: Injection](API08-Injection/README.md)
* [API09: Improper Assets Management](API09-Improper-Assets-Management/README.md)
* [API10: Insufficient Logging and Monitoring](API10-Insufficient-Logging-and-Monitoring/README.md)
