# shoppingapp — Props & ReactDOM.render() Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app shoppingapp
   ```
2. `src/Cart.js` — class component with `Itemname` and `Price`
   (received via props), rendered as a table row:
   ```jsx
   import React, { Component } from 'react';

   class Cart extends Component {
       constructor(props) {
           super(props);
           this.Itemname = props.Itemname;
           this.Price = props.Price;
       }

       render() {
           return (
               <tr>
                   <td>{this.Itemname}</td>
                   <td>{this.Price}</td>
               </tr>
           );
       }
   }

   export default Cart;
   ```
3. `src/OnlineShopping.js` — class component that initializes an array
   of 5 cart items in state, then loops through them and renders a
   `<Cart />` for each:
   ```jsx
   this.state = {
       cartItems: [
           { Itemname: 'Laptop', Price: 55000 },
           { Itemname: 'Mobile Phone', Price: 15000 },
           { Itemname: 'Headphones', Price: 2000 },
           { Itemname: 'Keyboard', Price: 1200 },
           { Itemname: 'Mouse', Price: 700 }
       ]
   };
   ...
   {this.state.cartItems.map((item, index) => (
       <Cart key={index} Itemname={item.Itemname} Price={item.Price} />
   ))}
   ```
4. `src/App.js` renders `<OnlineShopping />`.
5. `src/index.js` uses the classic **`ReactDOM.render()`** API (as
   called out in the lab objectives) to mount `App` into the DOM.
6. Run the app:
   ```
   npm start
   ```
7. Open `http://localhost:3000` — a table is shown listing all 5 cart
   items with their names and prices.

## How to use this folder

This zip already contains the finished components, so you don't need to
run `create-react-app` again. Just run:

```
cd shoppingapp
npm install
npm start
```

> Note: the 5 item names/prices weren't fully readable from the lab's
> screenshot, so sample placeholder data was used in `OnlineShopping.js`.
> Feel free to edit that array with your lab's actual item data.
