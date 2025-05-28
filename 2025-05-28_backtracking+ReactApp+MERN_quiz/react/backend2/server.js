const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const app = express();

app.use(cors());
app.use(express.json());

mongoose.connect('mongodb://localhost:27017/profile-manager', {
  useNewUrlParser: true,
  useUnifiedTopology: true,
})
.then(()=>console.log(`connected to database`))
.catch((err)=>console.log(`database connection error `+err))

const profileSchema = new mongoose.Schema({
  name: String,
  email: String,
  phone: String,
  degree: String,
  institution: String,
  year: String,
  interests: String,
  achievements: String,
});

const Profile = mongoose.model('Profile', profileSchema);

app.post('/profiles', async (req, res) => {
  const newProfile = new Profile(req.body);
  await newProfile.save();
  res.status(201).send(newProfile);
});

app.get('/profiles', async (req, res) => {
  const profiles = await Profile.find();
  res.send(profiles);
});

app.get('/profiles/:id', async (req, res) => {
  const profile = await Profile.findById(req.params.id);
  res.send(profile);
});

app.listen(3000, () => console.log(`Server running on port 3000`));
