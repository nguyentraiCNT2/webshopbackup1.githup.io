// UserTable.js

import React from 'react';

const UserTable = ({ users, viewDetails, editUser, deleteUser }) => (
  <table className="table mt-3">
    <thead>
      <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Actions</th>
      </tr>
    </thead>
    <tbody>
      {users.map(user => (
        <tr key={user.userId}>
          <td>{user.userId}</td>
          <td>{user.userName}</td>
          <td>
            <button className="btn btn-info" onClick={() => viewDetails(user.userId)}>Details</button>
            <button className="btn btn-warning" onClick={() => editUser(user.userId)}>Edit</button>
            <button className="btn btn-danger" onClick={() => deleteUser(user.userId)}>Delete</button>
          </td>
        </tr>
      ))}
    </tbody>
  </table>
);

export default UserTable;
