# fruit-shop-test
Project test to Asaitec

To run the application

open cmd inside application folder
type the command "mvn install"
after app creation change to destination folder
run command java -jar "application_name.jar"
The application already starts with a mass of data registered in the H2 bank in memory: List of 3 Products

H2 - Console: http://localhost:8080/h2/

Example of JSON

Create new Product:
```json
    {
        "name": "Stawberry",
        "price": 4.00
    }
```

Create new Order:
```json
{
    "totalAmount": 16,
    "orderLines": [
        {
            "product": {
                "id": 1,
                "name": "Apple",
                "price": 2.00
            },
            "amount": 3.00,
            "price": 6.00
        },
                {
            "product": {
                "id": 2,
                "name": "Pear",
                "price": 2.00
            },
            "amount": 5.00,
            "price": 10.00
        }

    ] 
}
```
