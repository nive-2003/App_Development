import axios from "axios";
let jwtToken = localStorage.getItem('Token')
const authHeader = `Bearer ${jwtToken}`;
console.log(jwtToken);
const headers = {
    Authorization : authHeader,
    "Content-Type":"application/json",
};

const URI = "http://localhost:8000";

const signUp = (register) => axios.post(`$(URI)/api/auth/register,register`)