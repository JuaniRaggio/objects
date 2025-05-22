class A
  def m_1
    self.m_3 # 3
  end

  def m_2
    m_3 # 3
  end

  def m_3
    3 # 3
  end
end

class B < A
  def m_1
    super # 3
  end

  def m_2
    super.m_1 # 4
  end

  def m_3
    4 # 4
  end
end

class C < B
  def m_1
    super # 4
  end

  def m_2
    m_2 # error(?
  end
  # m3 llama al de arriba osea 4
end

