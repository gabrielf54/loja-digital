import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.scss'],
})
export class DetailProductComponent {
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {
    console.log(data); // Exibe os dados do produto selecionado na tela de detalhes.
  }

  buyProduct() {
    
  }
}
