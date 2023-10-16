import React, { useState } from "react";
import "./adminPage.css";
import Obito_Profile from "../../assets/obito_profile.jpg";
import { motion } from "framer-motion";
import { categories_admin } from "./categories_admin";
import Category from "../Navbar/Categories/categories";
import { VideoData } from "../HomePage/Data/data";
import axios from "axios";
import { useEffect } from "react";

function Admin() {
  // start like save updation //
  // end of scroll right and changing the post //
  const [users, setUsers] = useState([]);
  useEffect(() => {
    loadUsers();
  }, []);
  const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/getdata");
    console.log(result);
    setUsers(result.data);
  };
  return (
    <>
      <div className="container-admin">
        <div className="categories-container-admin">
          {categories_admin.map((data) => (
            <Category key={data.id} data={data} />
          ))}
        </div>
        <div className="content-container-admin">
          <div className="Page-page-admin">
          <span className="MainPage_Video_Title">All Users</span>
            <motion.div className="PageVideo-page-admin">
              {users.map((user, index) => (
                <motion.div className="Page-Video-div-admin">
                  <img
                    src={Obito_Profile}
                    alt="profile_photo"
                    className="profile_photo_admin"
                  />
                  <div className="Page-Video-useremail-admin">{user.email}</div>
                  <div className="Page-Video-username-admin">
                    {user.username}
                  </div>
                  <div className="Page-Video-Delete-View">
                    <button className="delete_button_admin">Delete User</button>
                    <button className="view_button_admin">View Post</button>
                  </div>
                </motion.div>
              ))}
            </motion.div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Admin;
