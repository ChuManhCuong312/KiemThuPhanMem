describe('Kiểm thử chức năng giỏ hàng (Cart Test)', () => {

  beforeEach(() => {
    cy.visit('https://www.saucedemo.com');
    cy.get('#user-name').type('standard_user');
    cy.get('#password').type('secret_sauce');
    cy.get('#login-button').click();
  });

  it('Thêm sản phẩm vào giỏ hàng', () => {
    cy.get('.inventory_item').first()
      .find('.btn_inventory')
      .click();

    cy.get('.shopping_cart_badge')
      .should('have.text', '1');
  });

  it('Sắp xếp sản phẩm theo giá tăng dần', () => {
    cy.get('.product_sort_container')
      .select('lohi');

    cy.get('.inventory_item_price')
      .first()
      .should('have.text', '$7.99');
  });

  it('Xóa sản phẩm khỏi giỏ hàng', () => {
    cy.get('.inventory_item').first()
      .find('.btn_inventory')
      .click();

    cy.get('.btn_inventory').contains('Remove').click();

    cy.get('.shopping_cart_badge')
      .should('not.exist');
  });

  it('Kiểm thử quy trình thanh toán', () => {
    cy.get('.inventory_item').first()
      .find('.btn_inventory')
      .click();

    cy.get('.shopping_cart_link').click();
    cy.get('#checkout').click();

    cy.get('#first-name').type('John');
    cy.get('#last-name').type('Doe');
    cy.get('#postal-code').type('12345');

    cy.get('#continue').click();

    cy.url().should('include', '/checkout-step-two.html');
  });

});
