class EProduct:
    def __init__(self, name, price, brand, family, popularity = 0):
        self.product_attributes = {
            "name": name,
            "price": price,
            "brand": brand,
            "family": family,
            "popularity": popularity,
        }

    def __str__(self):
        return f"{self.product_attributes['name']}, {self.product_attributes['brand']} \
        is ${self.product_attributes['price']}, the product has been sold \
        {self.product_attributes['popularity']} times"

    @property
    def product_attributes(self):
        return self._product_attributes

    @product_attributes.setter
    def product_attributes(self, name, price, brand, family, popularity):
        if not isinstance(price, (float, int)) or price <= 0:
            raise ValueError("Price should be a positive float")
        if not isinstance(brand, str) or brand == "":
            raise ValueError("Missing: brand name")
        if not isinstance(name, str) or name == "":
            raise ValueError("Missing: product name")
        if not isinstance(family, str) or family == "":
            raise ValueError("Missing: family name")
        self._product_attributes = {
            "name": name.capitalize(),
            "price": price,
            "brand": brand.capitalize(),
            "family": family.capitalize(),
            "popularity": popularity,
        }

