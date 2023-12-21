// UserList.js - Component để hiển thị danh sách người dùng
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const UserList = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    // Gọi API để lấy danh sách người dùng khi component được mount
    axios.get('/tai-khoan-nguoi-dung/api')
      .then(response => setUsers(response.data))
      .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div>
      <h1>User List</h1>
      <ul>
        {users.map(user => (
          <li key={user.userId}>{user.userName}</li>
        ))}
      </ul>
    </div>
  );
};

export default UserList;
