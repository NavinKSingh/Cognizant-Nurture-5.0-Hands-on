import React, { Component } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = { selected: 'book' };

        this.showBook = this.showBook.bind(this);
        this.showBlog = this.showBlog.bind(this);
        this.showCourse = this.showCourse.bind(this);
    }

    showBook() {
        this.setState({ selected: 'book' });
    }

    showBlog() {
        this.setState({ selected: 'blog' });
    }

    showCourse() {
        this.setState({ selected: 'course' });
    }

    // Way 1: Conditional rendering using if / else if / else
    renderUsingIfElse() {
        if (this.state.selected === 'book') {
            return <BookDetails />;
        } else if (this.state.selected === 'blog') {
            return <BlogDetails />;
        } else {
            return <CourseDetails />;
        }
    }

    // Way 2: Conditional rendering using switch-case
    renderUsingSwitch() {
        switch (this.state.selected) {
            case 'book':
                return <BookDetails />;
            case 'blog':
                return <BlogDetails />;
            case 'course':
                return <CourseDetails />;
            default:
                return null;
        }
    }

    render() {
        const { selected } = this.state;

        // Way 3: Element variable
        let content;
        if (selected === 'book') {
            content = <BookDetails />;
        } else if (selected === 'blog') {
            content = <BlogDetails />;
        } else {
            content = <CourseDetails />;
        }

        return (
            <div>
                <h1>Blogger App</h1>

                <button onClick={this.showBook}>Book</button>{' '}
                <button onClick={this.showBlog}>Blog</button>{' '}
                <button onClick={this.showCourse}>Course</button>

                {/* Way 4: Ternary operator */}
                <p>
                    {selected === 'book'
                        ? 'Currently showing: Book Details'
                        : 'Not showing Book Details'}
                </p>

                {/* Way 5: Logical && operator */}
                {selected === 'blog' && <p>You are viewing the Blog section.</p>}
                {selected === 'course' && <p>You are viewing the Course section.</p>}

                <hr />
                <h3>1) Rendered using if / else if / else:</h3>
                {this.renderUsingIfElse()}

                <hr />
                <h3>2) Rendered using switch-case:</h3>
                {this.renderUsingSwitch()}

                <hr />
                <h3>3) Rendered using an element variable:</h3>
                {content}
            </div>
        );
    }
}

export default App;
