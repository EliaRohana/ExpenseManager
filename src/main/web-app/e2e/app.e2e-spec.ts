import { ExpenseManagerAppPage } from './app.po';

describe('expense-manager-app App', function() {
  let page: ExpenseManagerAppPage;

  beforeEach(() => {
    page = new ExpenseManagerAppPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
