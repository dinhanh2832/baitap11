package product.controller;

import product.model.Product;
import product.service.ProductService;
import product.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productServlet = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create" -> showListProduct(request, response);
            case "edit" -> {
            }
            case "delete" -> {
            }
            case "view" -> {
            }
            case "find" -> showFind(request, response);
            default -> listProduct(request, response);
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = this.productServlet.findAll();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/listProduct.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFind(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/findbyname.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit":

                break;
            case "delete":
                break;
            case "find" :
                findByName(request,response);
                break;
            default:
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Product> products = this.productServlet.findAll();
        String name = request.getParameter("Ten");
        double price = Double.parseDouble(request.getParameter("gia"));
        String producer = request.getParameter("Nhasanxuat");
        int id = (products.size() + 1);
        Product product = new Product(id, name, price, producer);
        this.productServlet.save(product);
//        response.sendRedirect("/products");
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void findByName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("Ten1");
        int id = this.productServlet.findIdByName(name);
        Product product = this.productServlet.findById(id + 1);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("product/product.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}