# v001

Cambiaremos la implementación de la clase **Tablero**: en lugar de guardar las fichas en la casilla en la que le corresponda, guardará la posición de las fichas.

<div align=center>

<table>
<tr>
<th>v000</th><th>v001</th>
</tr>
<tr>
<td width=50%>

```
ficha ficha ficha
ficha ficha ficha
ficha ficha ficha
```
</td>
<td width=50%>
  
```
Jugador 1   | coordenada | coordenada | coordenada |
Jugador 2   | coordenada | coordenada | coordenada |
```
</td>
</tr>
</table>

</div>

Por tanto, este estado del tablero:

<div align=center>

![](/images/estado001.png)

</div>

Quedaría almacenado así:

<div align=center>

<table>
<tr>
<th>v000</th><th>v001</th>
</tr>
<tr>
<td width=50%>

```
_ o _
o _ x
o x _
```
</td>
<td width=50%>
  
```
Jugador 1   | (2,1) | (3,1) | (1,2) |
Jugador 2   | (2,3) | (3,2) | null  |
```
</td>
</tr>
</table>

</div>

Y este estado:

<div align=center>

![](/images/estado002.png)

</div>

sería:

<div align=center>

<table>
<tr>
<th>v000</th><th>v001</th>
</tr>
<tr>
<td width=50%>

```
x o _
o _ x
o x _
```
</td>
<td width=50%>
  
```
Jugador 1   | (2,1) | (3,1) | (1,2) |
Jugador 2   | (2,3) | (3,2) | (1,1) |
```
</td>
</tr>
</table>

</div>