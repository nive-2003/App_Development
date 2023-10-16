import { createSlice } from "@reduxjs/toolkit";

export const userReducer = createSlice({
    name:"userr",
    initialState:{
        userr:null
    },
    reducers:{
        login:(state,action)=>{
            state.userr=action.payload;
        },
        logout:(state)=>{
            state.userr=null;
        }
    }  
})
export const {login,logout}=userReducer.actions;

export const selectuserr =(state)=>state.userr.userr;

export default userReducer.reducer;


