// ProductList.js
import React, { useEffect, useState } from 'react';
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  TablePagination,
  Typography,
  TextField,
  Button,
  Switch,
} from '@mui/material';
import axios from 'axios';

const API_BASE = 'http://192.168.29.118:4000/api/products';

function ProductList() {
  /* -------------------------------- state -------------------------------- */
  const [products, setProducts]     = useState([]);
  const [searchQuery, setSearchQuery] = useState('');
  const [page, setPage]             = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const [editingIdx, setEditingIdx] = useState(null);   // global index of row being edited
  const [editedProduct, setEditedProduct] = useState({});

  /* ------------------------------- helpers ------------------------------- */
  const fetchProducts = async (query = '') => {
    try {
      const { data } = await axios.get(
        `${API_BASE}/search?name=${encodeURIComponent(query)}`
      );
      setProducts(data);
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    fetchProducts(searchQuery);
  }, [searchQuery]);

  /* -------------------------- edit / save / delete ------------------------ */
  const beginEdit = (globalIdx) => {
    setEditingIdx(globalIdx);
    setEditedProduct({ ...products[globalIdx] });
  };

  const handleInputChange = (e, field) =>
    setEditedProduct({ ...editedProduct, [field]: e.target.value });

  const toggleInStock = () =>
    setEditedProduct({ ...editedProduct, inStock: !editedProduct.inStock });

  const saveChanges = async (id) => {
    try {
      await axios.put(`${API_BASE}/${id}`, editedProduct);
      setEditingIdx(null);
      fetchProducts(searchQuery);
    } catch (err) {
      console.error(err);
    }
  };

  const deleteProduct = async (id) => {
    try {
      await axios.delete(`${API_BASE}/${id}`);
      fetchProducts(searchQuery);
    } catch (err) {
      console.error(err);
    }
  };

  /* ------------------------------ pagination ------------------------------ */
  const handleChangePage = (_e, newPage) => setPage(newPage);
  const handleChangeRowsPerPage = (e) => {
    setRowsPerPage(parseInt(e.target.value, 10));
    setPage(0);
  };

  /* -------------------------------- render -------------------------------- */
  return (
    <div style={{ padding: 30 }}>
      <Typography variant="h5" fontWeight="bold" gutterBottom>
        Product List
      </Typography>

      <TextField
        label="Search Products by Name"
        variant="outlined"
        fullWidth
        sx={{ mb: 2 }}
        value={searchQuery}
        onChange={(e) => setSearchQuery(e.target.value)}
      />

      <TableContainer component={Paper}>
        <Table>
          {/* ---------------------- table header ---------------------- */}
          <TableHead>
            <TableRow sx={{ backgroundColor: '#0d6efd' }}>
              {['Name', 'Price', 'Category', 'In Stock', 'Actions'].map((h) => (
                <TableCell
                  key={h}
                  sx={{ color: 'white', fontWeight: 'bold' }}
                >
                  {h}
                </TableCell>
              ))}
            </TableRow>
          </TableHead>

          {/* ----------------------- table body ----------------------- */}
          <TableBody>
            {products
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map((product, idx) => {
                const globalIdx = page * rowsPerPage + idx;
                const isEditing = editingIdx === globalIdx;

                return (
                  <TableRow key={product._id}>
                    {/* ---------- name ---------- */}
                    <TableCell>
                      {isEditing ? (
                        <TextField
                          size="small"
                          value={editedProduct.name}
                          onChange={(e) => handleInputChange(e, 'name')}
                        />
                      ) : (
                        product.name
                      )}
                    </TableCell>

                    {/* ---------- price ---------- */}
                    <TableCell>
                      {isEditing ? (
                        <TextField
                          size="small"
                          type="number"
                          value={editedProduct.price}
                          onChange={(e) => handleInputChange(e, 'price')}
                        />
                      ) : (
                        `$${product.price}`
                      )}
                    </TableCell>

                    {/* ---------- category ---------- */}
                    <TableCell>
                      {isEditing ? (
                        <TextField
                          size="small"
                          value={editedProduct.category}
                          onChange={(e) => handleInputChange(e, 'category')}
                        />
                      ) : (
                        product.category
                      )}
                    </TableCell>

                    {/* ---------- in-stock ---------- */}
                    <TableCell>
                      {isEditing ? (
                        <Switch
                          checked={editedProduct.inStock}
                          onChange={toggleInStock}
                        />
                      ) : product.inStock ? (
                        'Yes'
                      ) : (
                        'No'
                      )}
                    </TableCell>

                    {/* ---------- actions ---------- */}
                    <TableCell sx={{ whiteSpace: 'nowrap' }}>
                      {isEditing ? (
                        <Button
                          variant="contained"
                          size="small"
                          color="success"
                          sx={{ textTransform: 'none', mr: 1 }}
                          onClick={() => saveChanges(product._id)}
                        >
                          SAVE
                        </Button>
                      ) : (
                        <Button
                          variant="outlined"
                          size="small"
                          color="primary"
                          sx={{ textTransform: 'none', mr: 1 }}
                          onClick={() => beginEdit(globalIdx)}
                        >
                          EDIT
                        </Button>
                      )}

                      <Button
                        variant="outlined"
                        size="small"
                        color="error"
                        sx={{ textTransform: 'none' }}
                        onClick={() => deleteProduct(product._id)}
                      >
                        DELETE
                      </Button>
                    </TableCell>
                  </TableRow>
                );
              })}
          </TableBody>
        </Table>

        {/* -------------------- pagination footer -------------------- */}
        <TablePagination
          component="div"
          rowsPerPageOptions={[10, 25, 50, 100]}
          count={products.length}
          rowsPerPage={rowsPerPage}
          page={page}
          onPageChange={handleChangePage}
          onRowsPerPageChange={handleChangeRowsPerPage}
        />
      </TableContainer>
    </div>
  );
}

export default ProductList;
