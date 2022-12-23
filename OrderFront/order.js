let orders = []
let numberOfOrders = prompt("Enter number of orders");
let counterPrice = 0;
let counterPinCode = 0;
createOrderArray()
function createOrderArray() {
    for (let index = 0; index < numberOfOrders; index++) {
        order = {
            item: "Order" + index,
            price: 1000 + index,
            pinCode: 45002 + index
        }
        orders.push(order)
    }
}
console.log(orders);
displayOrders();
//sort the orders by price
function sortByPrice() {
    //check if column is in ascending or descending and sort
    if (orders[0].price < orders[1].price) {
        orders.sort(function (order1, order2) {
            return order2.price - order1.price;
        });
    }
    else {
        orders.sort(function (order1, order2) {
            return order1.price - order2.price;
        });
    }
    displayOrders();
}

//sort the orders by priority
function sortByPinCode() {
    //check if column is in ascending or descending and sort
    if (orders[0].pinCode < orders[1].pinCode) {
        orders.sort(function (order1, order2) {
            return order2.pinCode - order1.pinCode;
        });
    }
    else {
        orders.sort(function (order1, order2) {
            return order1.pinCode - order2.pinCode;
        });
    }
    displayOrders();
}
//display as a table
function displayOrders() {
    let ordersPrint = '<tbody';
    for (let index = 0; index < orders.length; index++) {
        ordersPrint += '<tr>' + '<td>' + orders[index].item + '</td>' + '<td>' + orders[index].price + '</td>' + '<td>' + orders[index].pinCode + '</td>' + '</tr>';
    }
    ordersPrint += '</tbody>';
    document.getElementById("orders").innerHTML = ordersPrint;
}
//delete order 
function deleteOrder() {
    let decision = confirm("Are you sure to delete");
    if (decision) {
        orders.pop();
        displayOrders();
    }
}
