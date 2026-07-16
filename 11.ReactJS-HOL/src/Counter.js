import React, { Component } from 'react';

class Counter extends Component {
    constructor(props) {
        super(props);
        this.state = { count: 0 };

        this.handleIncrement = this.handleIncrement.bind(this);
        this.handleDecrement = this.handleDecrement.bind(this);
        this.incrementValue = this.incrementValue.bind(this);
        this.sayHello = this.sayHello.bind(this);
    }

    incrementValue() {
        this.setState((prevState) => ({ count: prevState.count + 1 }));
    }

    sayHello() {
        alert('Hello, welcome to the Event Examples App!');
    }

    // "Increment" button invokes multiple methods: increments the
    // value AND shows a static "Hello" message
    handleIncrement() {
        this.incrementValue();
        this.sayHello();
    }

    handleDecrement() {
        this.setState((prevState) => ({ count: prevState.count - 1 }));
    }

    render() {
        return (
            <div>
                <h2>Counter</h2>
                <p>Count: {this.state.count}</p>
                <button onClick={this.handleIncrement}>Increment</button>{' '}
                <button onClick={this.handleDecrement}>Decrement</button>
            </div>
        );
    }
}

export default Counter;
