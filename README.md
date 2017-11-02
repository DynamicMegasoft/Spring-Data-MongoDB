# Spring-Data-MongoDB
Spring Data MongoDB – Select fields and Retrieve

In MongoDB console, you can use field:1 to select the fields to return from a query -
> db.hosting.find({},{domain:1, count:1});

In Spring Data for MongoDB, you use
query.fields().include("fieldName");
