import { combineReducers, configureStore } from "@reduxjs/toolkit";
import userReducer from "./userReducer";
import storage from "redux-persist/lib/storage";
import { persistReducer , persistStore} from "redux-persist";

const persistConfig ={
    key:"root",
    version:1,
    storage,
};
const reducer=combineReducers({
    userr:userReducer,
});
const persistedReducer = persistReducer(persistConfig, reducer);
const store = configureStore({
    reducer : persistedReducer,
});
const persistor = persistStore(store);

export {store,persistor};