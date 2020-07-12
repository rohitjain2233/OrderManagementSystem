# OrderManagementSystem

1. OrderItemService

POST /products

Request:
{
  "price": 90,
  "productCode": "P105",
  "productName": "Cream"
}

Response Content Type 

{
  "productCode": "P105",
  "productName": "Cream",
  "price": 90
}

GET /products/{productCode}

Request: /products/P105

Response:

{
  "productCode": "P105",
  "productName": "Cream",
  "price": 90
}

Request: /products/P106

Error Response:

{
  "errorCode": "PRODUCT_NOT_FOUND_ERROR",
  "errorMsg": "Product not found with Code P106",
  "status": 404,
  "timestamp": "2020-07-12 10:02:58"
}

2. OrderService

POST /orders

Request:
{
   "customerFirstName":"Rohit",
   "customerLastName":"Jain",
   "shippingAddress":"Noida, UP",
   "email":"abc@gmail.com",
   "itemList":[
      {
         "productCode":"P101",
         "quantity":12
      }
   ]
}

Response:

{
    "orderId": 2,
    "customerFirstName": "Rohit",
    "customerLastName": "Jain",
    "email": "abc@gmail.com",
    "orderDate": "2020-07-12 10:06:14",
    "shippingAddress": "Noida, UP",
    "items": {
        "P101": 12
    },
    "total": 600
}

Error Senario:

Request:- /orders
{
   "customerFirstName":"Rohit",
   "customerLastName":"Jain",
   "shippingAddress":"Noida, UP",
   "email":"abc@gmail.com",
   "itemList":[
      {
         "productCode":"P103",
         "quantity":12
      }
   ]
}

Response:
{
    "errorCode": "PRODUCT_NOT_FOUND_ERROR",
    "errorMsg": "Product not found with Code P103",
    "status": 404,
    "timestamp": "2020-07-12 10:07:15"
}

GET /order/{orderId}

Request: /orders/2

Response:

{
    "orderId": 2,
    "customerFirstName": "Rohit",
    "customerLastName": "Jain",
    "email": "abc@gmail.com",
    "orderDate": "2020-07-12 10:06:14",
    "shippingAddress": "Noida, UP",
    "items": {
        "P101": 12
    },
    "total": 600
}

Error senario:-

Request:- orders/3

Response:
{
  "errorCode": "ORDER_NOT_FOUND_ERROR",
  "errorMsg": "Order not found with order Id: 3",
  "status": 404,
  "timestamp": "2020-07-12 10:14:30"
}
