// UserDetail.js - Component để hiển thị chi tiết một người dùng
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const UserDetail = ({ userId }) => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    // Gọi API để lấy thông tin chi tiết người dùng khi component được mount
    axios.get(`/tai-khoan-nguoi-dung/api/${userId}`)
      .then(response => setUser(response.data))
      .catch(error => console.error('Error fetching data:', error));
  }, [userId]);

  return (
    <div>
      <h1>User Detail</h1>
      {user && (
        <div>
          <p>User ID: {user.userId}</p>
          <p>User Name: {user.userName}</p>
          {/* Thêm các trường thông tin khác của người dùng */}
        </div>
      )}
    </div>
  );
};

export default UserDetail;
