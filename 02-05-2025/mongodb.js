/*1
Write a MongoDB query to find all employees who belong to the 'Engineering' 
department


Collection: 'employees'

Reference Document:
----------------------
{
  "employeeId": "E001",
  "name": "Aarav Sharma",
  "age": 28,
  "gender": "Male",
  "email": "aarav.sharma@example.com",
  "department": "Engineering",
  "salary": 720000,
  "isPermanent": true,
  "joiningDate": {
    "$date": "2019-06-15T00:00:00.000Z"
  },
  "skills": [
    "JavaScript",
    "Node.js",
    "MongoDB"
  ],
  "address": {
    "street": "12 MG Road",
    "city": "Bangalore",
    "state": "Karnataka",
    "pinCode": 560001
  }
}


Sample Output:
--------------
[
  { name: 'Aarav Sharma', age: 28, gender: 'Male' },
  { name: 'Neha Reddy', age: 29, gender: 'Female' }
]


Query Reference:
-------------------
printjson() : JS library function to display the JSON Object data.
In db.<collection>.find():
	db -> Refers to the database.
	<collection> -> Your collection name
	find() -> Method to write the selection and projection part of the query.

*/
	
printjson(
	db.employees.find({department:{$eq:"Engineering"}}, {name:1, age:1, gender:1, _id:0})
)
/*3
Write a MongoDB query to find employees whose age is between 28 and 35 (inclusive)


Sample Output:
--------------
[
  { name: 'Aarav Sharma', age: 28 },
  { name: 'Isha Verma', age: 32 }
]

*/
	
printjson(
	db.employees.find({"age":{$gte:28, $lte:35}}, {name:1, age:1, _id:0})
)
/*4
Write a MongoDB query to find employees who joined after January 1st, 2021.


Collection: 'employees'
Sample Output:
--------------
[
  {
    name: 'Rohan Mehta',
    age: 25,
    joiningDate: ISODate('2021-11-01T00:00:00.000Z')
  },
  {
    name: 'Ananya Iyer',
    age: 30,
    joiningDate: ISODate('2022-01-04T00:00:00.000Z')
  }
]

*/
	
printjson(
	db.employees.find({joiningDate:{$gt:ISODate("2021-01-01T00:00:00.000Z")}}, {name:1, age:1, joiningDate:1, _id:0})
)

/*5
Write a MongoDB query to find employees who have more than two skills listed.
Sample Output:
--------------
[
  {
    name: 'Aarav Sharma',
    skills: [ 'JavaScript', 'Node.js', 'MongoDB' ]
  },
  { 
    name: 'Rohan Mehta', 
    skills: [ 'Excel', 'Tally', 'GST' ] 
  }
]

*/
	
printjson(
// 	db.employees.find({skills:{$size:3}}, {name:1, skills:1, _id:0})
    db.employees.find({"skills.2":{$exists:true}}, {name:1, skills:1, _id:0})
)
/*6
Write a MongoDB query to find male employees who work in either the Sales or Finance department.
Sample Output:
--------------
[
  { name: 'Rohan Mehta', gender: 'Male', department: 'Finance' },
  { name: 'Vikram Singh', gender: 'Male', department: 'Sales' }
]*/
	
printjson(
	db.employees.find({department:{$in:["Sales", "Finance"]}}, {name:1, gender:1, department:1, _id:0})
)
/*7
Write a MongoDB query to find employees who have both "UI/UX" and "Figma" in 
their skillset.
Sample Output:
--------------
[ { name: 'Ananya Iyer', skills: [ 'UI/UX', 'Figma' ] } ]
*/
	
printjson(
	db.employees.find({skills:{$all:["UI/UX", "Figma"]}}, {name:1, skills:1, _id:0})
)

/*8
Write a MongoDB query to find employees who have both "JavaScript" and 
"Node.js" in their skills and are permanent employees

Sample Output:
--------------
[
  {
    name: 'Aarav Sharma',
    skills: [ 'JavaScript', 'Node.js', 'MongoDB' ]
  }
]

*/
	
printjson(
	db.employees.find({skills:{$all:["JavaScript", "Node.js"]}, isPermanent:true}, {name:1, skills:1, _id:0})
)

/*9
Write a MongoDB query to find employees who joined in the year 2021 
(based on the joiningDate field).
Sample Output:
--------------
[
  {
    name: 'Rohan Mehta',
    age: 25,
    joiningDate: ISODate('2021-11-01T00:00:00.000Z')
  },
  {
    name: 'Meera Nair',
    age: 31,
    joiningDate: ISODate('2021-05-12T00:00:00.000Z')
  }
]

*/
	
printjson(
	db.employees.find({joiningDate:{
	    $gte:ISODate('2021-01-01T00:00:00.000Z'), 
	    $lt:ISODate('2022-01-01T00:00:00.000Z')
	}},{name:1, age:1, joiningDate:1, _id:0})
)

/*10
Write a MongoDB query to find employees whose pin code is even and greater than 400000
Sample Output:
--------------
[
  {
    name: 'Siddharth Joshi',
    address: {
      street: '10 FC Road',
      city: 'Pune',
      state: 'Maharashtra',
      pinCode: 411004
    }
  },
  {
    name: 'Kavya Raj',
    address: {
      street: '3 BTM Layout',
      city: 'Bangalore',
      state: 'Karnataka',
      pinCode: 560076
    }
  }
]
*/
	
printjson(
	db.employees.find({"address.pinCode":{$gt:400000, $mod:[2,0]}}, {name:1, address:1, _id:0})
)

