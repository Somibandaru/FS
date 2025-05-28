import React, { useEffect, useState } from 'react';
import {
  Table, TableBody, TableCell, TableContainer, TableHead, TableRow,
  Paper, TablePagination, Typography
} from '@mui/material';
import axios from 'axios';

function ProductList() {
  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  useEffect(() => {
    axios.get('http://192.168.29.118:4000/')
      .then(res => setProducts(res.data))
      .catch(err => console.error(err));
  }, []);

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

      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell><strong>Name</strong></TableCell>
              <TableCell><strong>Price</strong></TableCell>
              <TableCell><strong>Category</strong></TableCell>
              <TableCell><strong>In Stock</strong></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {products
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map((product, index) => (
                <TableRow key={index}>
                  <TableCell>{product.name}</TableCell>
                  <TableCell>{product.price}</TableCell>
                  <TableCell>{product.category}</TableCell>
                  <TableCell>{product.inStock ? 'Yes' : 'No'}</TableCell>
                </TableRow>
              ))}
          </TableBody>
        </Table>
        <TablePagination
          rowsPerPageOptions={[5, 10, 20, 25, 50]}
          component="div"
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
