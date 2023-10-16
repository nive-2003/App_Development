import React, { useState } from 'react';
import { Outlet, Navigate } from 'react-router-dom';

export const ManagerAuth = () => {

    const Token = localStorage.getItem('Token') !== null;
    const Role =  localStorage.getItem('Role') === "MANAGER";

    return (

        Token && Role ? <Outlet /> : <Navigate to='/login' />
    )
};