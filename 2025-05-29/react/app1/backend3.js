const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const dotenv = require('dotenv');

const app = express();
app.use(cors());
dotenv.config();
app.use(express.json());

mongoose.connect(process.env.MONGO_URI)
  .then(() => console.log('connected to database'))
  .catch((err) => console.log('database not connected ' + err));

const schema = new mongoose.Schema({
  name: String,
  price: Number,
  category: String,
  inStock: Boolean,
});

const Product = mongoose.model('Product', schema);

const categories = Array.from({ length: 10 }, (_, i) => `Category ${i}`);

app.get('/api/products', async (req, res) => {
  try {
    const products = await Product.find({});
    res.status(200).json(products);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// ✅ New route for search
app.get('/api/products/search', async (req, res) => {
  try {
    const nameQuery = req.query.name || '';
    const regex = new RegExp(nameQuery, 'i'); // case-insensitive match
    const filteredProducts = await Product.find({ name: { $regex: regex } });
    res.status(200).json(filteredProducts);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// PUT /api/products/:id
app.put('/api/products/:id', async (req, res) => {
  try {
    const updatedProduct = await Product.findByIdAndUpdate(req.params.id, req.body, { new: true });
    res.json(updatedProduct);
  } catch (err) {
    res.status(500).json({ error: 'Update failed' });
  }
});

// DELETE /api/products/:id
app.delete('/api/products/:id', async (req, res) => {
  try {
    await Product.findByIdAndDelete(req.params.id);
    res.json({ message: 'Product deleted' });
  } catch (err) {
    res.status(500).json({ error: 'Delete failed' });
  }
});



app.listen(4000, () => {
  console.log('backend listening on port 4000');
});
