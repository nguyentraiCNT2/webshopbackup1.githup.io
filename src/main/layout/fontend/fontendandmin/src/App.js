
import './App.css';
import React from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import UserList from './Components/UserList';
import UserDetail from './Components/UserDetail';

const App = () => {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li>
              <Link to="/">User List</Link>
            </li>
            {/* Thêm các liên kết khác tại đây */}
          </ul>
        </nav>

        <hr />

        <Route path="/" exact component={UserList} />
        <Route path="/user/:userId" component={({ match }) => <UserDetail userId={match.params.userId} />} />
        {/* Thêm các Route khác tại đây */}
      </div>
    </Router>
  );
};

export default App;