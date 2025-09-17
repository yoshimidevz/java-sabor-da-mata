document.addEventListener("DOMContentLoaded", () => {
    // Mobile Menu Toggle
    const mobileMenuBtn = document.querySelector(".mobile-menu-btn");
    const nav = document.querySelector(".nav");

    if (mobileMenuBtn && nav) {
        mobileMenuBtn.addEventListener("click", () => {
            nav.classList.toggle("active");
        });
    }

    // Fetch and display categories on the index page
    const categoriesGrid = document.getElementById("categories-grid");
    if (categoriesGrid) {
        fetch("/api/categorias")
            .then(response => response.json())
            .then(categories => {
                categories.forEach(category => {
                    const card = `
                        <a href="${category.link}" class="card">
                            <div class="card-image">
                                <img src="${category.imagem}" alt="${category.nome}">
                            </div>
                            <div class="card-content">
                                <h3 class="card-title">${category.nome}</h3>
                                <p class="card-description">${category.descricao}</p>
                            </div>
                        </a>
                    `;
                    categoriesGrid.innerHTML += card;
                });
            })
            .catch(error => console.error("Error fetching categories:", error));
    }

    // Fetch and display featured products on the index page
    const featuredProductsGrid = document.getElementById("featured-products");
    if (featuredProductsGrid) {
        fetch("/api/produtos/destaque")
            .then(response => response.json())
            .then(products => {
                products.forEach(product => {
                    const card = `
                        <div class="product-card card">
                            <div class="product-image">
                                <img src="${product.imagem}" alt="${product.nome}">
                                <div class="product-overlay">
                                    <button class="add-to-cart-btn">
                                        <svg width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2">
                                            <path d="M3 3h2l.4 2M7 13h10l4-8H5.4m1.6 8L6 21h12M9 19.5a1.5 1.5 0 1 1 3 0 1.5 1.5 0 0 1-3 0zM20 19.5a1.5 1.5 0 1 1 3 0 1.5 1.5 0 0 1-3 0z"/>
                                        </svg>
                                        Adicionar
                                    </button>
                                </div>
                            </div>
                            <div class="card-content">
                                <h3 class="card-title">${product.nome}</h3>
                                <p class="card-description">${product.descricao}</p>
                                <div class="card-price">${product.precoFormatado}</div>
                            </div>
                        </div>
                    `;
                    featuredProductsGrid.innerHTML += card;
                });
            })
            .catch(error => console.error("Error fetching featured products:", error));
    }
});