import React, { useEffect, useState } from 'react';
import {
  Table, TableBody, TableCell, TableContainer, TableHead, TableRow,
  Paper, TablePagination, Typography, TextField, Button, Select, MenuItem
} from '@mui/material';
import axios from 'axios';

function ProductTable() {
  const [products, setProducts] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const [editId, setEditId] = useState(null);
  const [editData, setEditData] = useState({});

  const getAuthHeader = () => {
    const auth = JSON.parse(localStorage.getItem('auth'));
    return {
      headers: {
        Authorization: `Bearer ${auth?.token || ''}`
      }
    };
  };

  const fetchProducts = async () => {
    try {
      const res = await axios.get('http://192.168.29.118:4000/api/products', getAuthHeader());
      setProducts(res.data);
      setFiltered(res.data);
    } catch (err) {
      console.error(err);
      alert('Failed to fetch products. Are you logged in?');
    }
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  const handleSearch = async (e) => {
    const value = e.target.value;
    setSearchTerm(value);
    setPage(0);

    if (value.trim() === '') {
      setFiltered(products);
      return;
    }

    try {
      const res = await axios.get(
        `http://192.168.29.118:4000/api/products/search?name=${value}`,
        getAuthHeader()
      );
      setFiltered(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  const handleEdit = (product) => {
    setEditId(product._id);
    setEditData({ ...product });
  };

  const handleInputChange = (field, value) => {
    setEditData({ ...editData, [field]: value });
  };

  const handleSave = async () => {
    try {
      const res = await axios.put(
        `http://192.168.29.118:4000/api/products/${editId}`,
        editData,
        getAuthHeader()
      );
      const updated = products.map((p) => (p._id === editId ? res.data : p));
      setProducts(updated);
      setFiltered(updated);
      setEditId(null);
    } catch (err) {
      console.error(err);
    }
  };

  const handleDelete = async (id) => {
    try {
      await axios.delete(
        `http://192.168.29.118:4000/api/products/${id}`,
        getAuthHeader()
      );
      const updated = products.filter((p) => p._id !== id);
      setProducts(updated);
      setFiltered(updated);
    } catch (err) {
      console.error(err);
    }
  };

  const handleChangePage = (event, newPage) => setPage(newPage);

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(parseInt(event.target.value, 10));
    setPage(0);
  };

  return (
    <div style={{ padding: '30px' }}>
      <Typography variant="h5" fontWeight="bold" gutterBottom>
        Product List
      </Typography>

      <TextField
        fullWidth
        variant="outlined"
        label="Search Products by Name"
        value={searchTerm}
        onChange={handleSearch}
        style={{ marginBottom: '20px' }}
      />

      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow style={{ backgroundColor: '#1976d2' }}>
              <TableCell style={{ color: '#fff', fontWeight: 'bold' }}>Name</TableCell>
              <TableCell style={{ color: '#fff', fontWeight: 'bold' }}>Price</TableCell>
              <TableCell style={{ color: '#fff', fontWeight: 'bold' }}>Category</TableCell>
              <TableCell style={{ color: '#fff', fontWeight: 'bold' }}>In Stock</TableCell>
              <TableCell style={{ color: '#fff', fontWeight: 'bold' }}>Actions</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {filtered
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map((product) => (
                <TableRow key={product._id}>
                  <TableCell>
                    {editId === product._id ? (
                      <TextField
                        value={editData.name}
                        onChange={(e) => handleInputChange('name', e.target.value)}
                      />
                    ) : (
                      product.name
                    )}
                  </TableCell>

                  <TableCell>
                    {editId === product._id ? (
                      <TextField
                        type="number"
                        value={editData.price}
                        onChange={(e) => handleInputChange('price', parseFloat(e.target.value))}
                      />
                    ) : (
                      `$${product.price.toFixed(2)}`
                    )}
                  </TableCell>

                  <TableCell>
                    {editId === product._id ? (
                      <TextField
                        value={editData.category}
                        onChange={(e) => handleInputChange('category', e.target.value)}
                      />
                    ) : (
                      product.category
                    )}
                  </TableCell>

                  <TableCell>
                    {editId === product._id ? (
                      <Select
                        value={editData.inStock}
                        onChange={(e) => handleInputChange('inStock', e.target.value)}
                        style={{ width: 100 }}
                      >
                        <MenuItem value={true}>Yes</MenuItem>
                        <MenuItem value={false}>No</MenuItem>
                      </Select>
                    ) : (
                      product.inStock ? 'Yes' : 'No'
                    )}
                  </TableCell>

                  <TableCell>
                    {editId === product._id ? (
                      <Button
                        variant="contained"
                        style={{ backgroundColor: 'green', color: 'white', marginRight: '5px' }}
                        onClick={handleSave}
                      >
                        SAVE
                      </Button>
                    ) : (
                      <Button
                        variant="outlined"
                        style={{ color: '#1976d2', borderColor: '#1976d2', marginRight: '5px' }}
                        onClick={() => handleEdit(product)}
                      >
                        EDIT
                      </Button>
                    )}
                    <Button
                      variant="outlined"
                      style={{ color: 'red', borderColor: 'red' }}
                      onClick={() => handleDelete(product._id)}
                    >
                      DELETE
                    </Button>
                  </TableCell>
                </TableRow>
              ))}
          </TableBody>
        </Table>

        <TablePagination
          rowsPerPageOptions={[10, 25, 50, 100]}
          component="div"
          count={filtered.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
        />
      </TableContainer>
    </div>
  );
}

export default ProductTable;
