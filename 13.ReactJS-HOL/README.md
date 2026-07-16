# bloggerapp — Conditional Rendering Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app bloggerapp
   ```
2. Three simple components:
   - `src/BookDetails.js`
   - `src/BlogDetails.js`
   - `src/CourseDetails.js`
3. `src/App.js` selects among the three using **as many conditional
   rendering techniques as possible**, all driven by one `selected`
   state value (`'book' | 'blog' | 'course'`) set by three buttons:

   | # | Technique | Where used |
   |---|-----------|-----------|
   | 1 | `if / else if / else` | `renderUsingIfElse()` |
   | 2 | `switch-case` | `renderUsingSwitch()` |
   | 3 | Element variable (`let content; if(...) content = <X/>`) | inside `render()` |
   | 4 | Ternary operator (`cond ? a : b`) | the "Currently showing" text |
   | 5 | Logical `&&` operator | the Blog / Course section messages |

4. Run the app:
   ```
   npm start
   ```
5. Open `http://localhost:3000` and click **Book**, **Blog**, or
   **Course** — all five sections update together since they all read
   from the same `selected` state, demonstrating each conditional
   rendering technique side by side.

## How to use this folder

This zip already contains the finished components, so you don't need to
run `create-react-app` again. Just run:

```
cd bloggerapp
npm install
npm start
```
