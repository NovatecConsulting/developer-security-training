# API04: Lack of Resources and Rate Limiting

Quite often, APIs do not impose any restrictions on the size or number of resources that can be requested by the client/user. Not only can this impact the API server performance, leading to Denial of Service (DoS), but also leaves the door open to authentication flaws such as brute force.

API requests consume resources such as network, CPU, memory, and storage. The amount of resources required to satisfy a request greatly depends on the user input and endpoint business logic. Also, consider the fact that requests from multiple API clients compete for resources. An API is vulnerable if at least one of the following limits is missing or set inappropriately (e.g., too low/high):

* Execution timeouts
* Max allocable memory
* Number of file descriptors
* Number of processes
* Request payload size (e.g., uploads)
* Number of requests per client/resource
* Number of records per page to return in a single request response

## How To Prevent
* Docker makes it easy to limit memory, CPU, number of restarts, file descriptors, and processes.
* Implement a limit on how often a client can call the API within a defined timeframe.
* Notify the client when the limit is exceeded by providing the limit number and the time at which the limit will be reset.
* Add proper server-side validation for query string and request body parameters, specifically the one that controls the number of records to be returned in the response.
* Define and enforce maximum size of data on all incoming parameters and payloads such as maximum length for strings and maximum number of elements in arrays.