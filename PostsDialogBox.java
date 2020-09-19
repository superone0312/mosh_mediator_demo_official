
public class PostsDialogBox extends DialogBox {
    private ListBox postsListBox = new ListBox(this);
    private TextBox titleTextBox = new TextBox(this);
    private Button saveButton = new Button(this);

    public void testMethod(){
        postsListBox.setSelection("a post is selected");
        System.out.println("Editor shows: " + titleTextBox.getContent());
        System.out.println("Button status: " + saveButton.isEnabled());
        postsListBox.setSelection("");
        System.out.println("Editor shows: " + titleTextBox.getContent());
        System.out.println("Button status: " + saveButton.isEnabled());
    }

    @Override
    public void changed(UIControl control) {
        if (control == postsListBox){
            postSelected();
        } else if (control == titleTextBox){
            titleChanged();
        }
    }

    private void titleChanged(){
        var content = titleTextBox.getContent();
        var isEmpty = (content == null || content.isEmpty());
        saveButton.setEnabled(!isEmpty);
    }

    private void postSelected() {
        titleTextBox.setContent(postsListBox.getSelection());
        saveButton.setEnabled(true);
    }
    
}
