const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');
const dotenv = require('dotenv')

const app = express();
app.use(cors())
dotenv.config();
app.use(express.json());

mongoose.connect(process.env.MONGO_URI)
.then(()=>console.log('connected to database'))
.catch((err)=>console.log('database not connected '+err))

const schema =  new mongoose.Schema({
    name: String,
    price: Number,
    category: String,
    inStock: Boolean
})

const Product = mongoose.model('Product', schema);

// const categories = ['Electronics', 'Clothing', 'Books', 'Beauty', 'Home']
const categories = Array.from({ length: 10 }, (_, i) => `Category ${i}`);


const generate = ()=>{
    const p=[]
    for(let i=1;i<=100;i++){
        p.push({
            name:`Product ${i}`,
            price: (Math.random()*100).toFixed(2),
            category:categories[Math.floor(Math.random()*categories.length)],
            inStock: Math.random()>0.5
        })
    }
    return p;
}


const seeding=async()=>{
    await Product.deleteMany();
    await Product.insertMany(generate());
    console.log('seeding complete')
}
// seeding(); /*run seeding code seperately*/

app.get('/',async(req, res)=>{
    try{
        const products = await Product.find({});
        res.status(200).json(products);
    }
    catch(err){
        res.status(500).json({message: err.message})
    }
})



app.listen(4000, ()=>{
    console.log('backend listening on port 4000')
})
