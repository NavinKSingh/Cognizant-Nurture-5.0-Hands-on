import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cartItems: [
                { Itemname: 'Laptop', Price: 55000 },
                { Itemname: 'Mobile Phone', Price: 15000 },
                { Itemname: 'Headphones', Price: 2000 },
                { Itemname: 'Keyboard', Price: 1200 },
                { Itemname: 'Mouse', Price: 700 }
            ]
        };
    }

    render() {
        return (
            <div>
                <h2>Online Shopping Cart</h2>
                <table border="1" cellPadding="8">
                    <thead>
                        <tr>
                            <th>Item Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.cartItems.map((item, index) => (
                            <Cart key={index} Itemname={item.Itemname} Price={item.Price} />
                        ))}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default OnlineShopping;
