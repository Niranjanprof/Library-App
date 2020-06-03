package com.neeru.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    private Button btnAlreadyRead,btnWishlist,btnCurrentlyReading,btnFavorite;
    private ImageView bookImage;
    private TextView name,author,pages,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

        //TODO
        Book book = new Book(1,"The Alchemist","Paulo Coelho",230,"data:image/webp;base64,UklGRg4OAABXRUJQVlA4IAIOAABQQgCdASqwAAoBPw18sFEnJD+upZYK4/ghieRt4DKzw+qaUmJnI921LfGz6Dvu8OXon/u+8E54/0c/6Hpk/Vu9ADzq/We/2Ti856OzvgBPk7QKAvVrjUvJnqIdL0lL7IQAAwTFGTEDb6Jc6Vs/fC3XOltAU2ZaV92CJn1+X4vn7zj1Ah3CmWQ/siwvhlONRus9UtX9EK3u35Wx2XJVCH4uf6TiP4YIhrDf/Sb//7+KK7mbzEhJmeSf8XAOmwMHZF1JDQKEap6eyrTxWYqal1AsQct4kB0det2JpJxA6bp5q52DO1B738fncRF1oYOwFWkNxgWZWBcR/ZaPdow9B7V92TAjVYDIByACuOiCBlvXIw9H7Lbz1jWwHwekVAJg7EWnKEXURdw8Z+tRGIVvWHZb8SSg1IuAXljfJGVfUM23CNvxxoUzGHzVW4pHdwUyevs+1xs5983sUurqAaLcTwAtQV3n3zceehnv+MKEt2DS7y1DXc503uQIXVGLhKxYY32FdxtREmAnnhGS2JGfrLYf/7WnHqje4zkRBAh68UKcTdXYxCQb9ScK6lf4r9R/NNqMRvn49uFD1UdsPiP8/7pjCf+3y5jyWgs3hv7CKcpGodjq9MKJJD30yVEho87exwrdAFBr+gujswYEpZJDlSsKQOKRK3GDm9dUUsH9rGIjub/DVf9ZANADA6WYGRRelHtkdkd5mHO1YGfgAAD87tPGGE2gNVq1bOCZr++3wF7RF+GRdc//4M5N2x36/c7t/HbU1txIQUyFbfDIHekOsm0lzMOLF0YsJFBVp6x9JOAzKNZng5z5DvtJEUZHr+aLI01pZ0uyVURXrOCb71FCY5Al6aqoCoQntFyqtwXq9zqAZsgm9hy+FosXOLS/UXlQiRRubKLW4c7lkDKGFjCvtIhe2mIa3xRKGJ9F4PvLqvvBeW0paXB/cYYAab57aoN8YoH8nzq9UNgYg1QTXpv7OyiBKo0j6IRBsUdt8we7KAXlEcpWkm04Q2eoUmRJO3rjYOb6/+x6zSmhR0yVV736TMmf/S5TeiqJup5GlWeMRAEpizahyR68VjAeVD4F/n5VWbCJtZJUHl6DUBYAwIXeyQxnOXHtSZMZj1WpNnFJvGir1gC6hgEAfFvhcdsX++FOR7pD9fI4nptjqZsFJ7snRyjrdQh6c/xu1EGKdGZ9Ke2BYNZJVGdJeTJ3R9AUXvHtXN1W3uYDo2gtavvlf+JvMxNnQb22v5wfBm0o7uXQPnlbq2gLF2w61D0C5HwDW41+CS6FD8K2kf5/27Zt8lGj8Ypshna+5dNAE1zmIqGMqaMfIJ2IXHWxFaEb4zMHSZR3UE2AydsE69aWrIjG98wNrKOGeOrzIcO+muIiQJjFkoMz1AS2iyaOueZIYiOnSO/DZxrd88vB0pB5dpMlsINHFBLzRtzsN6qzQqnhAiQOlELNMGhcBDLVt8eWsLEKdasOsh7RSzPY87czcXPZQC7aABe33yKfxbFFWDob+XE8J2nybd21faioTSDnB7Yl3kW06kTZV/TVP/zoVrdrmfy3fGavMSBxwxmZlMo9xENF+UDU81xNF1B011xDnUoy6cGIYTBs9YIl/o0+07yhYWBpsrDgZyYZMRuFZnVIG0Np4ivHgDeQwXJFzFObSIJY3ixGgEWzUvDxwj3Dcw034YswnozsOkqBdNjOLCa9p/UYkZHryRdnQDY+vXEIYn/9lOvmnuax59M0DhdkoHN3pC0P78gCsBtHgqsYmucR4eezW4tXt9em6cx6sqTV1fELo3NWuhi2VZzeAfgn6/3OEJJtHN35PRsvL8t1Oq+2Ol2eF+uE5xIG/PSiliRXG/HWSsQi4itVa7F9235wlJg/RHWuOAvljHWEaeDWoQu6TovHnEzcc0d+KLdxG26dvnYCTwdjrGKuV0gZUVPrN8HdYMoc78ryefPvmi9Qy6lzmmvkHt37V+GHKhEqreKlz5vM3QjkkYv+gE0CuCiMsxfg0I4RQTj+kuD/XzWY3xFe9LvpymROhHExq+fknbPSAVlSPrxks3FdNaJEvdojmIoebtVIGGBTab1nKScqeT39qX4Yskl8KtuXqWZQVPshui7P1CEzSE7nU+HtRrD8fY3SNYCgYv7ouvKPU9i3sBTJ0JWEs1FfpynGwNBZLZBgcf60sIYK7Me5r65r0+w8uvBlhJwWYnrZB2GW+nXRhPK42bWmkePFU3QqehAx+/lGC9e1SqljRfVdPE/bJtlCab7TDOA00b+FKDvwa2c075QgmxdPRw19/XS2A5f/CC53wBWksj3zkKsvU667iBmESPNaxlkCnOXGwxqdWTLoedxmZ4SPldKfrJUPDqhGVwjuonw+jnre6ww7k3tpJY7iwViYFf+nYzcq4x8YafhCSxrUehslLbuIg71vY4i5BkP4RS3zawvGCOnN4rgB8+GPElN9XwhXjyTJnDXrPJ2ZXlOsFEwgcTMiYebtpJ3huoGLGHLcqyi7lCJNZ3md9VLEyaANXF7ldouczihOgM3mv2DjXblF/tE9C1W5fwKwgwmS+MqTGEuiVXd++0fpQXQTi8ZNgrDs7A6c/DiOaC9/rKahOISJZQCYtUuTWvH5dvUfIjSrRYyFZHV1dEyFtugT7Z+GelvYdbnwkgy7fQ9CQeOcNT4boxhVba2vVYhvyaYXwi0+QJWN2frazZLbaFowtGq95vrnC4iwLoBaPKrfV5yOF4B6OBZbgoVAnUYk+v0t47L24pugQa7RGBEkh2aUwXIGKyjnkow6NB8u23+5qf6YGPSOor2O3ci5ku/GruD80sWnOAHRnmUHteEp6y+Yta4nUgZPTZZoJDkqV/Zg1QWn/billF9q0N9tq6tPj1GDACzLq7hgKH9jLnoM/R+XGqs/TFZ2FL+yueSoQOGBmLF+Z4R9Z4+3XSmR1OxERxGCxYqy12AtP/hIzSoYOi54xDZO6NWD3pMuS3/HQOK+Sm7s05wsXyFAXA9J6Zxxb2tRK64un7TLkwJbaPC90pDG4bnbncl2jnnVhdkl7KmlV9AzH4Oi5mPfiRUHmoL4H0Ilzw3wX1oi9BFyEsAnhEOpfcApGmlPT5SYGWD7EyeVRpzy8kQIHc+LTVUoBdyNtiS8VmZCjHq3MWY3qb2NEtNHPOH2vw7zZwQwlkDTwEDoyTwxjyPqoJtuSAOh+DAkEpCM9HwVPWyC7IrlTnbmibyVIqRvzM0E2RKFbBlricAsyMTVNvKWXqhYCBgzEcEd0iidpD3Yl80qR9hbgTkkS606oF4RGII6BgZ+dYI6wVz+XTIOslSVCTdHN2eod3IdySeCK4t8SwaTIF1L6Qcvul0QsXwdfYInCKfu+BiiO5oN+hb6EqdjG0tqTxf3fEZFtwHNuvMdBnGwOFa1Iz0rjvLWxkNfRbPC4JDkqM6rRzetxFO3SMGDB7ihF1/3XPAYMTH/X05iaIP8YsGHlZU/UdZVJFBwJkgQXJ5G6hj/ohFLArqB0yOedQD1gvubUvfit59bfE7BuEj44/UNuWxOBXZMJt47jQKpCJE0oWq0PK6tX6xvOoITgG42qVghlGtxoepUjzyN6UW7CE4wdKAqgHsf8eQz2XRa6qW6gFCOUN3TRfCU7byskQOIY3ZHrs/RNP+1yJFYl1+SwIvkoq0+SJ2aTEAx5F4DfcB/L322cJ8zvbug7CyFWuf8hGGUmnzBLNhiaAbeAZAYwnz3kR+YNP0GqX4wOyM2hUIQMZmhf9J9qeiT2m+8wuNbjCmt9Dy2jTmqCajuJX//bDZ4QPVP4c5GPZGub69MnqA+vjiOs+ufI7bjwi3cd8CfwoxOAJVCMk1IBExSrLqXzekjBd2hDUuTjNd5tmEmLqRZtzJnuRV36eEH3dg/9xiU3nx5iJV/tzVWW/ChoRsdD/stcFPJjxl71yp6sH7lh3OL9WMq8BP1FyAQiDbVU6UvtjkMABIseLSrzWenWCGeI0z9fwFyH2qZ8eoSrVjWQ9Akdx6cPVdT4vgOHuCcwymuFP96BLqTp7iWY39j20is3q8v9fm7f8avFqtgjV2XPqajOLAf0peE1pKvZKxSYf8AxgDXBFfUy1YaaYlDAFIiSDfGFqrwHH3PUb9r8zFBBLoy3YtwVt7tkGsa2M5ODNl4CZJWyxWnRvvrbNvCOjkW+wr+auJg2wXKX7Dsr6ya+kiUuPkjmqdFigFhKicsAiMhk+XDJjXZAaeq07DkFjh1lgBlVRMtEqBZAN2hJqGX6BK3Bm8Wdq/kVGh6q94lo4JqZV1hRuWvL2qoHTwf4iwRdMHyhXvBlbVbureP1e33/fOmcOYGMHr6q7LmO/AAi4wIvuQWMEJCpVUny1ThXUOTlgbGTe9zANSqpbv3CHHxB1L5zBwvFvveNLTzQkx6idEMsjuU1JaRzhHfiLo7lUHvtf7XW6kjG53nnqkb161XYFoY1AH8Yja6LU/WiGuK3nCHitukQsmt6xfZHAVK3bZEu1bVEcFWUFZqC5heW5zq6rsgnKUqaxpXbnFHpdACSKa1FwFx61agnHr67fX+BDWgWxYctfk54nInEU7PnYTfgu54Y9KSoyA9GX+ss74KFXV/fWwbt/GEzg+F2men0BvSLqhDdmVK0Ntk8Q846KwNVUqWzlfCdysWgO9PFRkXr1TTQTil3KFiv4iOQCpqoOB0vNo1w1dUhy3/w6O5YqXsGOntGU2QvIS7btwnFWLCBgPn30pZ3BRxlx+sOVe3Dxl2E9bemfBTMr98aREU4HvBFCGwj4VQFw99X0Hwdx160McfzcAA","Magical Story of Santiago","The Alchemist by Paulo Coelho continues to change the lives of its readers forever. With more than two million copies sold around the world, The Alchemist has established itself as a modern classic, universally admired.\n" +
                "\n" +
                "Paulo Coelho's masterpiece tells the magical story of Santiago, an Andalusian shepherd boy who yearns to travel in search of a worldly treasure as extravagant as any ever found.\n" +
                "\n" +
                "The story of the treasures Santiago finds along the way teaches us, as only a few stories can, about the essential wisdom of listening to our hearts, learning to read the omens strewn along life's path, and, above all, following our dreams.");

        setData(book);


    }

    private void setData(Book book) {
        name.setText(book.getName());
        author.setText(book.getAuthor());
        pages.setText(String.valueOf(book.getPages()));
        description.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageurl()).into(bookImage);
    }

    private void initViews() {
        btnAlreadyRead = findViewById(R.id.alreadyread);
        btnWishlist = findViewById(R.id.wishlist);
        btnCurrentlyReading = findViewById(R.id.currentlyreading);
        btnFavorite = findViewById(R.id.fav);
        bookImage = findViewById(R.id.coverImageView);
        name = findViewById(R.id.namefield);
        author = findViewById(R.id.authorfield);
        pages = findViewById(R.id.pagesfield);
        description = findViewById(R.id.longfeild);
    }
}