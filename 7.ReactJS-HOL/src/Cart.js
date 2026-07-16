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
