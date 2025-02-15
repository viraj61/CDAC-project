// react 
import React from "react";
// css
import "./App.css";
// browserrouter 
import Payment from "./payment/Payment";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
// Components
import Header from './Component/Header';
import Footer from "./Component/Footer";
// pages
import Home from "./pages/Home";
// About pages
import AboutUs from "./pages/Order/AboutUs";
import Blog from "./pages/Order/OrdersPage";
import BlogCategory from "./pages/Order/AcceptedOrdersPage";
import Contact from "./pages/Order/Contact";
// Shop pages
import Shop from "./pages/Shop/Shop";
import ShopGridCol3 from "./pages/Shop/ShopGridCol3";
import ShopListCol from "./pages/Shop/ShopListCol";
import ShopCart from "./pages/Shop/ShopCart";
import ShopCheckOut from "./pages/Shop/ShopCheckOut";
import ShopWishList from "./pages/Shop/ShopWishList";
// Store pages
import StoreList from "./pages/store/StoreList";
import SingleShop from "./pages/store/SingleShop";
// Account pages
import MyAccountOrder from "./pages/Accounts/OrderList";
import MyAccount from "./pages/Accounts/MyAccount"; 
import MyAcconutPaymentMethod from "./pages/Accounts/MyAcconutPaymentMethod";
import MyAccountForgetPassword from "./pages/Accounts/MyAccountForgetPassword";
import MyAccountSignIn from "./pages/Accounts/MyAccountSignIn";
import MyAccountSignUp from "./pages/Accounts/MyAccountSignUp";
import UserEditPage from "./pages/Accounts/UserEditPage";
import ProductGrid from "./pages/ProductGrid";
import Productdetail from "./pages/ProductDetail";
import PaymentSuccess from "./pages/Accounts/PaymentSuccess";
import DeleteAccount from "./pages/Accounts/DeleteAccount";
import EditProduct from "./pages/store/EditProduct";
const App = () => {
  return (
    <div>
      <Router>
        <Header/>
        <Routes>
          <Route path="/Grocery-react/" element={<ProductGrid />} />
          {/* Shop pages */}
          <Route path="/Shop" element={<Shop />} />
          <Route path="/payment-success" element={<PaymentSuccess />} />
          <Route path="/productdetail/:id" element={<Productdetail/>} />
          <Route path="/ShopGridCol3" element={<ShopGridCol3 />} />
          <Route path="/ShopListCol" element={<ShopListCol />} />
          <Route path="/ShopWishList" element={<ShopWishList />} />
          <Route path="/ShopCheckOut" element={<ShopCheckOut />} />
          <Route path="/ShopCart" element={<ShopCart />} />
          {/* Store pages */}
          <Route path="/StoreList" element={<StoreList />} />
          <Route path="/SingleShop" element={<SingleShop />} />
          <Route path="/edit-product/:productId" element={<EditProduct />} />

          {/* Accounts pages */}
          <Route path="/MyAccountOrder" element={<MyAccountOrder />} />
          <Route path="/MyAccountEdit" element={<UserEditPage />} />
          <Route path="/MyAcconutDelete" element={<DeleteAccount />} />
          <Route path="/MyAccountSetting" element={<MyAccount />} />
          <Route path="/MyAcconutPaymentMethod" element={<MyAcconutPaymentMethod />} />
          {/* <Route path="/MyAccountAddress" element={<MyAccountAddress />} /> */}
          <Route path="/MyAccountForgetPassword" element={<MyAccountForgetPassword />} />
          <Route path="/MyAccountSignIn" element={<MyAccountSignIn />} />
          <Route path="/MyAccountSignUp" element={<MyAccountSignUp />} />
          <Route path="/payment" element={<Payment/>}/>
          
          {/* About pages */}
          <Route path="/Blog" element={<Blog />} />
          <Route path="/BlogCategory" element={<BlogCategory />} />
          <Route path="/Contact" element={<Contact />} />
          <Route path="/AboutUs" element={<AboutUs />} />
        </Routes>
        <Footer/>
      </Router>
    </div>
  );
};

export default App;
