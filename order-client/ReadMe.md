# API's to for Order

## Create a new order

### Request

`POST /api/createOrder/`

    {
        "tableNumber":1,
        "deviceId":"tablet1",
        "menuItem": [{
             "itemName": "veg-curry",
             "quantity":2
         },
         {
             "itemName": "roti",
             "quantity":2
         }]
    }
