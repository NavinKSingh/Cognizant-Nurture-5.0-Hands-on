import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then((response) => response.json())
            .then((data) => {
                const posts = data.map(
                    (item) => new Post(item.id, item.title, item.body)
                );
                this.setState({ posts: posts });
            })
            .catch((error) => {
                console.error('Error fetching posts:', error);
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        this.setState({ hasError: true });
        alert('Something went wrong while loading posts: ' + error.toString());
    }

    render() {
        if (this.state.hasError) {
            return <h2>Something went wrong while displaying the posts.</h2>;
        }

        return (
            <div>
                {this.state.posts.map((post) => (
                    <div key={post.id}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;
