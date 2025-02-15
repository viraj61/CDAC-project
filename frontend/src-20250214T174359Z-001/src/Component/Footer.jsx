import React from "react";
import { Link } from "react-router-dom";
import "@fortawesome/fontawesome-free/css/all.min.css";
import groceryshop from "../images/homegrownlogo.jpg";
import amazonpay from "../images/amazonpay.svg";
import american from "../images/american-express.svg";
import mastercard from "../images/mastercard.svg";
import paypal from "../images/paypal.svg";
import visa from "../images/visa.svg";

const Footer = () => {
  let date = new Date();
  let year = date.getFullYear();
  return (
    <div>
      <>
        <footer className="footer mt-8">
          <div className="overlay" />
          <div className="container">
            <div className="row footer-row">
              <div className="col-sm-6 col-lg-3 mb-30">
                <div className="footer-widget">
                  <div className="footer-logo">
                    <Link to="/">
                      <img
                        src={groceryshop}
                        style={{ width: 300, padding: 20, marginLeft: "-30px" }}
                        alt="logo"
                      />
                    </Link>
                  </div>
                  <p className="mb-30">
                    We deliver more than your expectations and help you to grow
                    your business exponentially by providing customized
                    applications. So, don’t just think, get ready to convert
                    your ideas into reality.
                  </p>
                </div>
                <div className="dimc-protect">
                  <div className="col-lg-5 text-lg-start text-center mb-2 mb-lg-0">
                    <h4>Payment Partners</h4>
                    <ul className="list-inline d-flex mb-0">
                      <li className="list-inline-item">
                        <Link to="#!">
                          <img src={amazonpay} alt="footerfreshcart" />
                        </Link>
                      </li>
                      <li className="list-inline-item">
                        <Link to="#!">
                          <img src={american} alt="footerfreshcart" />
                        </Link>
                      </li>
                      <li className="list-inline-item">
                        <Link to="#!">
                          <img src={mastercard} alt="footerfreshcart" />
                        </Link>
                      </li>
                      <li className="list-inline-item">
                        <Link to="#!">
                          <img src={paypal} alt="footerfreshcart" />
                        </Link>
                      </li>
                      <li className="list-inline-item">
                        <Link to="#!">
                          <img src={visa} alt="footerfreshcart" />
                        </Link>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              {/* <div className="col-sm-6 col-lg-3 mb-30">
                <div className="footer-widget mb-0">
                  <h4>All Category</h4>
                  <div className="line-footer" />
                  <div className="row">
                    <div className="col">
                      <ul className="footer-link mb-0">
                        <li>
                          <Link to="#">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Dairy, Bread &amp; Eggs
                          </Link>
                        </li>
                        <li>
                          <Link to="#">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Snacks &amp; Munchies
                          </Link>
                        </li>
                        <li>
                          <Link to="#">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Fruits &amp; Vegetables
                          </Link>
                        </li>
                        <li>
                          <Link to="#">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Cold Drinks &amp; Juices
                          </Link>
                        </li>
                        <li>
                          <Link to=" ">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Breakfast &amp; Instant Food
                          </Link>
                        </li>
                        <li>
                          <Link to=" ">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Bakery &amp; Biscuits
                          </Link>
                        </li>
                        <li>
                          <Link to=" ">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Chicken, Meat &amp; Fish
                          </Link>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div> */}
              <div className="col-sm-6 col-lg-3 mb-30">
                <div className="footer-widget mb-0">
                  <h4>For Consumers</h4>
                  <div className="line-footer" />
                  <div className="row">
                    <div className="col">
                      <ul className="footer-link mb-0">
                        <li>
                          <Link to=" ">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Careers
                          </Link>
                        </li>
                        <li>
                          <Link to="/ShopCart">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Promos &amp; coupons
                          </Link>
                        </li>
                        <li>
                          <Link to="/MyAccountOrder">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>
                            Shipping
                          </Link>
                        </li>
                        <li>
                          <Link to="/MyAccountOrder">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Product Returns
                          </Link>
                        </li>
                        <li>
                          <Link to="/MyAcconutPaymentMethod">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            Payments
                          </Link>
                        </li>
                        <li>
                          <Link to="/Contact">
                            <span>
                              <i className="fa fa-angle-right" />
                            </span>{" "}
                            FAQ
                          </Link>
                        </li>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="footer-bar ">
            <div className="container text-center">
              <div className="footer-copy">
                <div className="copyright">
                  © {year} All Rights Reserved By Homegrown
                  {/* <Link
                    to="https://nigammishra.github.io/nigam-portfolio/"
                    target="_blank"
                  >
                     @nigammishra
                  </Link> */}
                </div>
              </div>
            </div>
          </div>
        </footer>
      </>
    </div>
  );
};

export default Footer;
