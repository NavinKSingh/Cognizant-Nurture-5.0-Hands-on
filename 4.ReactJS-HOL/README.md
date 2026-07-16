# blogapp — Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app blogapp
   ```
2. Create `Post.js` in `src` — a simple model class for a post:
   ```js
   class Post {
       constructor(id, title, body) {
           this.id = id;
           this.title = title;
           this.body = body;
       }
   }

   export default Post;
   ```
3. Create `Posts.js` in `src` — a **class-based component**:
   - `constructor()` initializes `state = { posts: [], hasError: false }`
   - `loadPosts()` uses the Fetch API to get posts from
     `https://jsonplaceholder.typicode.com/posts` and stores them in state
   - `componentDidMount()` calls `loadPosts()` so data loads as soon as
     the component mounts
   - `render()` displays each post's title (`<h3>`) and body (`<p>`)
   - `componentDidCatch()` catches any rendering error in this component
     and shows it as an `alert()`

   ```jsx
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
   ```
4. Add `Posts` component to `App.js`.
5. Run the app:
   ```
   npm start
   ```
6. Open `http://localhost:3000` — the app fetches posts from
   JSONPlaceholder and displays each post's title and body.

## How to use this folder

This zip already contains the finished components, so you don't need to
run `create-react-app` again. Just run:

```
cd blogapp
npm install
npm start
```

Internet access is required at runtime since `loadPosts()` calls the
public JSONPlaceholder API.
