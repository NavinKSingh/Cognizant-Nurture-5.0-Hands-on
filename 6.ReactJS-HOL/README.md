# TrainersApp — React Router Hands-on Lab Solution

## Steps followed (as per the lab)

1. Create the React project:
   ```
   npx create-react-app TrainersApp
   ```
2. `src/Trainer.js` — model class:
   ```js
   class Trainer {
       constructor(trainerId, name, email, phone, technology, skills) {
           this.trainerId = trainerId;
           this.name = name;
           this.email = email;
           this.phone = phone;
           this.technology = technology;
           this.skills = skills;
       }
   }

   export default Trainer;
   ```
3. `src/TrainersMock.js` — mock trainer data (5 sample trainers).
4. Install React Router:
   ```
   npm install react-router-dom
   ```
5. `src/TrainersList.js` — receives `trainers` as a prop and renders
   each trainer's name as a clickable `Link` to `/trainers/:id`.
6. `src/Home.js` — simple welcome message component.
7. `src/App.js` — sets up `BrowserRouter`, a nav with `Link`s to Home
   and Trainers, and `Routes`/`Route`:
   - `/` → `Home`
   - `/trainers` → `TrainersList`
   - `/trainers/:id` → `TrainerDetail`
8. `src/TrainerDetails.js` — uses the `useParams()` hook to read `id`
   from the URL, looks it up in the mock data, and displays the
   trainer's full details.
9. Run the app:
   ```
   npm start
   ```
10. Open `http://localhost:3000`:
    - `/` shows the Home welcome message
    - `/trainers` shows the clickable trainers list
    - clicking a trainer's name navigates to `/trainers/:id` and shows
      that trainer's details

## How to use this folder

This zip already contains the finished components, so you don't need to
run `create-react-app` again. Just run:

```
cd TrainersApp
npm install
npm start
```

> Note: exact mock-data field values (names, emails, phone numbers,
> skills) weren't fully readable from the lab's screenshots, so sample
> placeholder data was used in `TrainersMock.js`. Feel free to edit that
> file with your lab's actual trainer records.
