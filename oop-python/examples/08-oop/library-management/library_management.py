class Book:
    TITLE = 0
    CODE = 1
    def __init__(self, title, code):
        self.book_attributes = (title, code)

    def get_title(self):
        return self.book_attributes[self.TITLE]

    def get_code(self):
        return self.book_attributes[self.CODE]
    
    @property
    def book_attributes(self):
        return self._book_attributes

    @book_attributes.setter
    def book_attributes(self, attributes):
        if not isinstance(attributes[self.TITLE], str):
            raise ValueError("Book title should be a string")
        if attributes[self.TITLE] == "":
            raise ValueError("Missing book title")
        to_assign = (attributes[self.TITLE].capitalize(), attributes[self.CODE])
        self._book_attributes = to_assign


class Owned_books:
    def __init__(self, name):
        self.owner_name = name
        self.owned_books = {}

    @staticmethod
    def check_book_type(book):
        if not isinstance(book, Book):
            raise ValueError("Book is not of type class Book")

    def new_book(self, book):
        Owned_books.check_book_type(book)
        if book.get_title() not in self.owned_books:
            self.owned_books[book.get_title()]["book_data"] = book
            self.owned_books[book.get_title()]["book_owner"] = self.owner_name
            self.owned_books[book.get_title()]["owned"] = 1
        else:
            self.owned_books[book.get_title()]["owned"] += 1

    def len_book(self, book, unowned = False):
        Owned_books.check_book_type(book)
        if book.get_title() not in self.owned_books:
            return False
        self.owned_books[book.get_title()]["owned"] -= 1
        if self.owned_books[book.get_title()]["owned"] <= 0 and unowned:
            del self.owned_books[book.get_title()]
        return True


class User(Owned_books):
    def __init__(self, name):
        self.name = name
        super().__init__(self.name)

    def get_book(self, book):
        Owned_books.check_book_type(book)
        self.new_book(book)

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, name):
        if not isinstance(name, str):
            raise ValueError("Name should be a string")
        if name == "":
            raise ValueError("Missing user name")
        self._name = name


class Library(Owned_books):
    def __init__(self, capacity, library_name):
        self.library_name = library_name
        self.capacity = capacity
        # Underscore means that its "private" even though private word doesn't exist, its a
        # convesion that this type of variable shouldn't be accessed directly or changed
        self._borrowed_books = {}
        super().__init__(self.library_name)

    @staticmethod
    def check_usr_type(usr):
        if not isinstance(usr, User):
            raise ValueError("User is not of type class User")

    def return_book(self, usr, book):
        Library.check_usr_type(usr)
        Owned_books.check_book_type(book)
        if usr.name in self._borrowed_books:
            del self._borrowed_books[usr.name][book.get_title()]
        self.append_book(book)

    def append_book(self, book):
        Owned_books.check_book_type(book)
        self.new_book(book)

    def borrow_book(self, usr, book):
        Library.check_usr_type(usr)
        if usr.name in self._borrowed_books:
            self._borrowed_books[usr.name][book.get_title()] = book
        self.len_book(book)
    
    def get_usr_info(self, usr):
        Library.check_usr_type(usr)
        # Returns a dictionary with the borrowed books. Key = name
        return self._borrowed_books[usr.name]

    @property
    def library_name(self):
        return self._library_name

    @library_name.setter
    def library_name(self, library_name):
        if library_name is not str:
            raise ValueError("Library name should be a string")
        if library_name == "":
            raise ValueError("Missing library name")
        self._library_name = library_name

