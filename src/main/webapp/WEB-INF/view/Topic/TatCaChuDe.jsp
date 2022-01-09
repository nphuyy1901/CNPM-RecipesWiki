<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" />
    <script
      src="https://kit.fontawesome.com/1147679ae7.js"
      crossorigin="anonymous"
    ></script>
    <link
      rel="stylesheet"
      href="https://unpkg.com/swiper/swiper-bundle.min.css"
    />

    <!-- font awesome cdn link  -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    />
    <link rel="stylesheet" href="css/allchude.css" />

    <!--link bootstrap-->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    />
    <title>RecipesWiki</title>
  </head>

  <body>
    <div class="Mcontainer">
        <nav class="navbar">
          <div class="hamburger-menu">
            <div class="line line-1"></div>
            <div class="line line-2"></div>
            <div class="line line-3"></div>
          </div>
  
          <div class="mn_logo">
            <img src="./Image/burger/food_logo.png" alt="" />
          </div>
          <ul class="nav-list">
            <li class="nav-item">
              <a href="#" class="nav-link">Tải lên công thức</a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">Sự kiện</a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">Sự kiện của tôi</a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">Bộ sưu tập của tôi</a>
            </li>
            <li class="nav-item">
              <a href="#" class="nav-link">Món của tôi</a>
            </li>
            <div class="hot-tag">
              <li class="nav-item">
                <p>Hot tag</p>
              </li>
              <li class="nav-tag">
                <a href="#" class="nav-link">#monanngayTet</a>
              </li>
              <li class="nav-tag">
                <a href="#" class="nav-link">#AnSang</a>
              </li>
              <li class="nav-tag">
                <a href="#" class="nav-link">#AnTrua</a>
              </li>
              <li class="nav-tag">
                <a href="#" class="nav-link">#AnToi</a>
              </li>
              <li class="nav-tag">
                <a href="#" class="nav-link">#Dauhu</a>
              </li>
            </div>
          </ul>
        </nav>
      </div>
      
      <header class="header__menu" id="myHeader">
  
          <nav>
              <ul>
                  <li class=""><a href="./trang_chu.html" class="menu-item">Trang chủ</a></li>
                  <li class=""><a href="./search1.html" class="menu-item">Tìm kiếm</a></li>
                  <li class="" ><a href="./trang_chu.html" class="menu-item"><span >RecipesWiki</span></a></li>
                  <li class="has-submenu">
                      <a href="" class="menu-item">Chủ đề</a>
                      <ul class="submenu">
                        <li><a href="#"  >Ăn sáng</a></li>
                        <li><a href="#" >Ăn trưa</a></li>
                        <li><a href="#"  >Ăn sáng</a></li>
                        
                      </ul>
                  </li>
                  <li class="active"><a href="./aboutus.html" class="menu-item">About us</a></li>
                  <li class="btn_account"> <a href="./account.html" class="menu-item"><img src="./Image/icon/account.png" /></a></li>
              </ul>  
          </nav>
  
      </header>
   
    <div class="container">


    <div class="container">
      <div class="search-container">
        <div class="row">
          <div class="col-md-3">
            <h3>Các chủ đề nổi bật</h3>
          </div>
          <div class="col-md-9">
            <div class="search">
              <form action="">
                <input
                  type="text"
                  class="form-search"
                  placeholder="Tên món, nguyên liệu, chủ đề,..."
                />
                <button type="submit" class="btn-search">
                  Tìm kiếm
                  <img src="Image/icon/search.png" alt="" />
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>

      <div class="topic-container">
        <div class="row" id="topic1">
          <div class="col-md-3">
            <img class="pic-menu" src="Image/menu/menu-1.jpg" alt="" />
          </div>
          <div class="col-md-9">
            <h3>Điểm mặt các món ngon, cứ nhìn là thấy Tết</h3>
            <p>
              Ẩm thực ngày tết ở mỗi vùng miền vô cùng đa dạng và phong phú. Tuy
              nhiên, dù xa đâu, dù xưa hay nay, luôn có những món ăn chỉ cần
              nhìn là thấy Tết.
            </p>
          </div>
        </div>

        <div class="row" id="topic2">
          <div class="col-md-3">
            <img class="pic-menu" src="Image/menu/menu-2.jpg" alt="" />
          </div>
          <div class="col-md-9">
            <h3>Điểm mặt các món ngon, cứ nhìn là thấy Tết</h3>
            <p>
              Ẩm thực ngày tết ở mỗi vùng miền vô cùng đa dạng và phong phú. Tuy
              nhiên, dù xa đâu, dù xưa hay nay, luôn có những món ăn chỉ cần
              nhìn là thấy Tết.
            </p>
          </div>
        </div>

        <div class="row" id="topic3">
          <div class="col-md-3">
            <img class="pic-menu" src="Image/menu/menu-3.jpg" alt="" />
          </div>
          <div class="col-md-9">
            <h3>Điểm mặt các món ngon, cứ nhìn là thấy Tết</h3>
            <p>
              Ẩm thực ngày tết ở mỗi vùng miền vô cùng đa dạng và phong phú. Tuy
              nhiên, dù xa đâu, dù xưa hay nay, luôn có những món ăn chỉ cần
              nhìn là thấy Tết.
            </p>
          </div>
        </div>
        <div class="row" id="topic4">
          <div class="col-md-3">
            <img class="pic-menu" src="Image/menu/menu-4.jpg" alt="" />
          </div>
          <div class="col-md-9">
            <h3>Điểm mặt các món ngon, cứ nhìn là thấy Tết</h3>
            <p>
              Ẩm thực ngày tết ở mỗi vùng miền vô cùng đa dạng và phong phú. Tuy
              nhiên, dù xa đâu, dù xưa hay nay, luôn có những món ăn chỉ cần
              nhìn là thấy Tết.
            </p>
          </div>
        </div>

        <div class="showmore">
          <button id="showmore">Xem thêm</button>
        </div>
      </div>
    </div>

    <script language="javascript">
      document.getElementById("showmore").onclick = function () {
        document.getElementById("topic3").style.display = "block";
        document.getElementById("topic4").style.display = "block";
      };
    </script>
    <script>
      window.onscroll = function () {
        myFunction();
      };

      var header = document.getElementById("myHeader");
      var sticky = header.offsetTop;

      function myFunction() {
        if (window.pageYOffset > sticky) {
          header.classList.add("sticky");
        } else {
          header.classList.remove("sticky");
        }
      }
    </script>

     <script>
        window.onscroll = function() {myFunction()};
        
        var header = document.getElementById("myHeader");
        var sticky = header.offsetTop;
        
        function myFunction() {
          if (window.pageYOffset > sticky) {
            header.classList.add("sticky");
          } else {
            header.classList.remove("sticky");
          }

          
        }
    </script>

    <script src="./js/burger.js"></script>
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- Bootstrap JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </body>
</html>
    