import pytest
from jar import Jar

def test_raises():
    assert Jar().capacity == 12
    assert Jar(14).capacity == 14
    with pytest.raises(ValueError, match = "Capacity should never be negative"):
        Jar(-1)
    with pytest.raises(ValueError, match = "Size of the Jar exceeded"):
        Jar(0).deposit(1)
    with pytest.raises(ValueError, match = "Can't deposit a negative amount"):
        Jar(1).deposit(-1)
    with pytest.raises(ValueError, match = "Can't withdraw a negative amount"):
        Jar(1).withdraw(-1)
    with pytest.raises(ValueError, match = "Size of the Jar should never be negative"):
        Jar(1).withdraw(1)

def test_str():
    jar = Jar()
    jar.deposit(1)
    assert str(jar) == "🍪"
    assert jar.size == 1
    jar.deposit(10)
    assert str(jar) == "🍪" * 11
    assert jar.size == 11
    jar.withdraw(10)
    assert str(jar) == "🍪"
    assert jar.size == 1
    jar.deposit(10)
    assert str(jar) == "🍪" * 11
    assert jar.size == 11
    jar.withdraw(2)
    assert str(jar) == "🍪" * 9
    assert jar.size == 9


