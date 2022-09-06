# API05: Broken Function Level Authorization

Complex access control policies with different hierarchies, groups, and roles, and an unclear separation between administrative and regular functions, tend to lead to authorization flaws. By exploiting these issues, attackers gain access to other users’ resources and/or administrative functions.

The best way to find broken function level authorization issues is to perform deep analysis of the authorization mechanism, while keeping in mind the user hierarchy, different roles or groups in the application, and asking the following questions:

* Can a regular user access administrative endpoints?
* Can a user perform sensitive actions (e.g., creation, modification, or erasure) that they should not have access to by simply changing the HTTP method (e.g., from GET to DELETE)?
* Can a user from group X access a function that should be exposed only to users from group Y, by simply guessing the endpoint URL and parameters (e.g., /api/v1/users/export_all)?

Don’t assume that an API endpoint is regular or administrative only based on the URL path.

## How To Prevent

Your application should have a consistent and easy to analyze authorization module that is invoked from all your business functions. Frequently, such protection is provided by one or more components external to the application code.

* The enforcement mechanism(s) should deny all access by default, requiring explicit grants to specific roles for access to every function.
* Review your API endpoints against function level authorization flaws, while keeping in mind the business logic of the application and groups hierarchy.
* Make sure that all of your administrative controllers inherit from an administrative abstract controller that implements authorization checks based on the user’s group/role.
* Make sure that administrative functions inside a regular controller implements authorization checks based on the user’s group and role.

