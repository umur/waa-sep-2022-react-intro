import { FC } from "react";
import Footer from "../Footer";
import Header from "../Header";
import { LayoutProps } from "./types";

const Layout: FC<LayoutProps> = ({ children }) => {
  return (
    <>
      <Header />
      <main>{children}</main>
      <Footer />
    </>
  );
};

export default Layout;
