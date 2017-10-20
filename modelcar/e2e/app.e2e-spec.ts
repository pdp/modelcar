import { ModelcarPage } from './app.po';

describe('modelcar App', () => {
  let page: ModelcarPage;

  beforeEach(() => {
    page = new ModelcarPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
