// App.js

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import UserTable from './components/UserTable';

const App = () => {
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(1);
  const [users, setUsers] = useState([]);

  useEffect(() => {
    updateUserTable(currentPage);
  }, [currentPage]);

  const updateUserTable = (page) => {
    axios.get(`http://localhost:1412/tai-khoan-nguoi-dung/api?page=${page}&limit=2`)
      .then(response => {
        const { listResult, page, totalPage } = response.data;
        setUsers(listResult);
        setCurrentPage(page);
        setTotalPages(totalPage);
      })
      .catch(error => {
        console.error('Error fetching user data:', error);
      });
  };

  const handlePrevClick = () => {
    if (currentPage > 1) {
      setCurrentPage(currentPage - 1);
    }
  };

  const handleNextClick = () => {
    if (currentPage < totalPages) {
      setCurrentPage(currentPage + 1);
    }
  };

  return (
    <div className="container mt-5">
      <h1>User Account Management</h1>

      <a className="btn btn-primary" href="./create.html" role="button">Add New User</a>

      <UserTable
        users={users}
        viewDetails={(userId) => window.location.href = `/html/details.html?userId=${userId}`}
        editUser={(userId) => window.location.href = `/html/edit.html?userId=${userId}`}
        deleteUser={(userId) => {
          axios.delete(`http://localhost:1412/tai-khoan-nguoi-dung/api/${userId}`)
            .then(() => {
              alert('User deleted successfully!');
              updateUserTable(currentPage);
            })
            .catch(error => {
              console.error('Error deleting user:', error);
              alert('Error deleting user. Please try again.');
            });
        }}
      />

      <div style={{ display: 'flex', margin: 'auto', marginTop: '20px' }}>
        <button onClick={handlePrevClick} className="btn btn-secondary">Previous</button>
        <p style={{ margin: '0 20px' }}><span id="currentPage">{currentPage}</span> / <span id="totalPages">{totalPages}</span></p>
        <button onClick={handleNextClick} className="btn btn-secondary">Next</button>
      </div>
    </div>
  );
};

export default App;
