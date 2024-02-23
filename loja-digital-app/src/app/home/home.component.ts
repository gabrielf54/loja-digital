import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DetailProductComponent } from '../detail-product/detail-product.component';
import { ProductService } from '../product.service';
import { Product } from '../product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  public products: Product[] = []; // Inicialize como array vazio
  private currentPage = 0;
  private pageSize = 6; // Número de produtos por "página" ou slide

  constructor(
    private productService: ProductService,
    private dialog: MatDialog
  ) {}

  ngOnInit() {
    this.productService.getAll().forEach((data) => {
      this.products = data;
      console.log(this.products);
      
    });
  }

  // Retorna os produtos para a página atual
  get productsToShow() {
    const startIndex = this.currentPage * this.pageSize;
    return this.products.slice(startIndex, startIndex + this.pageSize);
  }

  // Vai para a próxima página (slide)
  nextPage() {
    const totalPages = Math.ceil(this.products.length / this.pageSize);
    this.currentPage = (this.currentPage + 1) % totalPages;
    console.log(this.products);
  }

  // Vai para a página anterior (slide)
  previousPage() {
    const totalPages = Math.ceil(this.products.length / this.pageSize);
    this.currentPage = (this.currentPage - 1 + totalPages) % totalPages;
  }

  trackByProducts(index: number, product: any): number {
    return product.id;
  }

  openProductModal(product: any) {
    const dialogRef = this.dialog.open(DetailProductComponent, {
      width: '700px',
      height: '450px',
      data: { product: product }, // Você pode passar dados para o modal aqui
    });

    dialogRef.afterClosed().subscribe((result) => {
      console.log('O modal foi fechado');
    });
  }
}
