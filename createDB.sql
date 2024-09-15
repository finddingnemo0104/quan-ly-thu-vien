USE [master]
GO
/****** Object:  Database [QuanLyThuVien]    Script Date: 9/14/2024 3:21:17 PM ******/
CREATE DATABASE [QuanLyThuVien]
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyThuVien].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyThuVien] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyThuVien] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyThuVien] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyThuVien] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyThuVien] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyThuVien] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyThuVien] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyThuVien] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyThuVien] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyThuVien] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyThuVien] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyThuVien] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyThuVien] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyThuVien] SET QUERY_STORE = ON
GO
ALTER DATABASE [QuanLyThuVien] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [QuanLyThuVien]
GO
/****** Object:  Table [dbo].[CT_PHIEU_MUON]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_PHIEU_MUON](
	[idSach] [int] NOT NULL,
	[idPhieuMuon] [int] NOT NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_CTPM] PRIMARY KEY CLUSTERED 
(
	[idSach] ASC,
	[idPhieuMuon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_PHIEU_TRA]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_PHIEU_TRA](
	[idSach] [int] NOT NULL,
	[idPhieuTra] [int] NOT NULL,
	[soLuong] [int] NULL,
	[trangThaiSach] [tinyint] NULL,
 CONSTRAINT [PK_CTPT] PRIMARY KEY CLUSTERED 
(
	[idSach] ASC,
	[idPhieuTra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOAI_SACH]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAI_SACH](
	[id] [int] NOT NULL,
	[tenLoai] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NGUOI_DOC]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NGUOI_DOC](
	[id] [int] NOT NULL,
	[sdt] [nvarchar](15) NULL,
	[ngaySinh] [date] NULL,
	[diaChi] [nvarchar](100) NULL,
	[hoTen] [nvarchar](100) NULL,
	[CCCD] [nvarchar](20) NULL,
	[hanSuDung] [date] NULL,
	[soLuongMuonChoPhep] [tinyint] NULL,
	[trangThaiViPham] [tinyint] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHA_XUAT_BAN]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHA_XUAT_BAN](
	[id] [int] NOT NULL,
	[ten] [nvarchar](100) NULL,
	[diaChi] [nvarchar](100) NULL,
	[sdt] [char](15) NULL,
	[email] [varchar](320) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NHAN_VIEN]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NHAN_VIEN](
	[id] [int] NOT NULL,
	[hoTen] [nvarchar](100) NULL,
	[ngaySinh] [nvarchar](100) NULL,
	[diaChi] [nvarchar](100) NULL,
	[CCCD] [nvarchar](20) NULL,
	[vaiTro] [tinyint] NULL,
	[matKhau] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHIEU_MUON]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHIEU_MUON](
	[id] [int] NOT NULL,
	[idNhanVien] [int] NULL,
	[idNguoiDoc] [int] NULL,
	[ngayMuon] [date] NULL,
	[ngayTra] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHIEU_TRA]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHIEU_TRA](
	[id] [int] NOT NULL,
	[idNguoiDoc] [int] NULL,
	[ngayTraThatSu] [date] NULL,
	[tienPhat] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SACH]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SACH](
	[id] [int] NOT NULL,
	[tenSach] [nvarchar](100) NULL,
	[giaSach] [money] NULL,
	[soLuong] [int] NULL,
	[trangThai] [tinyint] NULL,
	[idTacGia] [int] NULL,
	[idNhaXuatBan] [int] NULL,
	[idLoaiSach] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TAC_GIA]    Script Date: 9/14/2024 3:21:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TAC_GIA](
	[id] [int] NOT NULL,
	[hoTen] [nvarchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CT_PHIEU_MUON] ([idSach], [idPhieuMuon], [soLuong]) VALUES (1, 1, 2)
INSERT [dbo].[CT_PHIEU_MUON] ([idSach], [idPhieuMuon], [soLuong]) VALUES (1, 3, 3)
INSERT [dbo].[CT_PHIEU_MUON] ([idSach], [idPhieuMuon], [soLuong]) VALUES (1, 4, 2)
INSERT [dbo].[CT_PHIEU_MUON] ([idSach], [idPhieuMuon], [soLuong]) VALUES (1, 5, 1)
INSERT [dbo].[CT_PHIEU_MUON] ([idSach], [idPhieuMuon], [soLuong]) VALUES (2, 2, 5)
INSERT [dbo].[CT_PHIEU_MUON] ([idSach], [idPhieuMuon], [soLuong]) VALUES (2, 3, 1)
INSERT [dbo].[CT_PHIEU_MUON] ([idSach], [idPhieuMuon], [soLuong]) VALUES (3, 2, 5)
GO
INSERT [dbo].[CT_PHIEU_TRA] ([idSach], [idPhieuTra], [soLuong], [trangThaiSach]) VALUES (1, 1, 2, 0)
INSERT [dbo].[CT_PHIEU_TRA] ([idSach], [idPhieuTra], [soLuong], [trangThaiSach]) VALUES (1, 3, 1, 0)
INSERT [dbo].[CT_PHIEU_TRA] ([idSach], [idPhieuTra], [soLuong], [trangThaiSach]) VALUES (1, 4, 1, 0)
INSERT [dbo].[CT_PHIEU_TRA] ([idSach], [idPhieuTra], [soLuong], [trangThaiSach]) VALUES (2, 2, 5, 0)
INSERT [dbo].[CT_PHIEU_TRA] ([idSach], [idPhieuTra], [soLuong], [trangThaiSach]) VALUES (2, 3, 0, 0)
INSERT [dbo].[CT_PHIEU_TRA] ([idSach], [idPhieuTra], [soLuong], [trangThaiSach]) VALUES (3, 2, 5, 0)
GO
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (1, N'Kinh dị')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (2, N'Ngôn tình')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (3, N'Trinh thám')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (4, N'Lịch sử')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (5, N'Khoa học và công nghệ')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (6, N'Viễn tưởng')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (7, N'Thiếu nhi')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (8, N'Tâm lý')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (9, N'Tôn giáo')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (10, N'Văn học tuổi mới lớn')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (11, N'Văn học kinh điển, phiêu lưu')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (12, N'Truyện thiếu nhi')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (13, N'Thơ')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (14, N'Tiểu thuyết')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (15, N'Tiểu sử')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (16, N'Tự truyện')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (17, N'Truyện ngắn')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (18, N'H?i ký')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (19, N'K? nang s?ng')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (20, N'Kinh t?')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (21, N'Chính tr?')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (22, N'Tri?t h?c')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (23, N'Ngh? thu?t')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (24, N'Du l?ch')
INSERT [dbo].[LOAI_SACH] ([id], [tenLoai]) VALUES (25, N'?m th?c')
GO
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (1, N'0963852741', CAST(N'2002-05-16' AS Date), N'230 Lê Lợi, phường 8, quận 5, TP HCM', N'Nguyễn Minh Quân', N'080705963456', CAST(N'2025-05-04' AS Date), 19, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (2, N'0987456253', CAST(N'2001-05-07' AS Date), N'05 Lê Lai, phường 7, quận 8', N'Lý Gia Hân', N'040302789654', CAST(N'2025-05-06' AS Date), 19, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (3, N'0396547336', CAST(N'2005-05-01' AS Date), N'172/6 Tôn Đức Thắng, phường 5, quận 6, TP HCM', N'Lê Minh Quân', N'060504321785', CAST(N'2025-05-06' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (4, N'0987654321', CAST(N'1995-01-15' AS Date), N'123 Nguyễn Văn Cừ, Quận 5, TP HCM', N'Nguyễn Thị Thu Hà', N'123456789213', CAST(N'2025-12-31' AS Date), 10, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (5, N'0978654321', CAST(N'1993-04-20' AS Date), N'456 Võ Thị Sáu, Quận 3, TP HCM', N'Trần Minh Hoàng', N'987654321673', CAST(N'2024-08-15' AS Date), 15, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (6, N'0908123456', CAST(N'1989-12-02' AS Date), N'789 Trường Chinh, Quận Tân Bình, TP HCM', N'Lê Hồng Phúc', N'654321987342', CAST(N'2026-02-01' AS Date), 12, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (7, N'0912123456', CAST(N'2000-05-10' AS Date), N'101 Lý Thường Kiệt, Quận Tân Phú, TP HCM', N'Phạm Văn Bình', N'321654987234', CAST(N'2024-11-30' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (8, N'0933123456', CAST(N'1997-07-21' AS Date), N'202 Lý Tự Trọng, Quận 1, TP HCM', N'Hoàng Thị Lan', N'951753456876', CAST(N'2025-09-25' AS Date), 18, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (9, N'0942123456', CAST(N'1996-08-15' AS Date), N'303 Phan Đăng Lưu, Quận Phú Nhuận, TP HCM', N'Nguyễn Văn Tuấn', N'753159456358', CAST(N'2026-06-30' AS Date), 16, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (10, N'0953123456', CAST(N'1992-11-25' AS Date), N'404 Điện Biên Phủ, Quận Bình Thạnh, TP HCM', N'Vũ Thị Hương', N'456789123384', CAST(N'2025-05-05' AS Date), 12, 1)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (11, N'0964123456', CAST(N'1998-03-08' AS Date), N'505 Nguyễn Đình Chiểu, Quận 3, TP HCM', N'Lý Thị Mai', N'951753852495', CAST(N'2026-01-15' AS Date), 14, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (12, N'0975123456', CAST(N'1994-02-22' AS Date), N'606 Cách Mạng Tháng 8, Quận 10, TP HCM', N'Ngô Đức Minh', N'654852357358', CAST(N'2024-12-01' AS Date), 17, 1)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (13, N'0986123456', CAST(N'1991-06-16' AS Date), N'707 Lê Hồng Phong, Quận 5, TP HCM', N'Trịnh Văn Nam', N'456852147094', CAST(N'2025-10-20' AS Date), 19, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (14, N'0901234567', CAST(N'1990-03-15' AS Date), N'123 Nguyễn Huệ, Quận 1, TP HCM', N'Nguyễn Văn Anh', N'079090123456', CAST(N'2026-03-15' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (15, N'0912345678', CAST(N'1992-07-22' AS Date), N'456 Lê Lợi, Quận 3, TP HCM', N'Trần Thị Bình', N'079092345678', CAST(N'2026-07-22' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (16, N'0923456789', CAST(N'1988-11-30' AS Date), N'789 Hai Bà Trưng, Quận 5, TP HCM', N'Lê Hoàng Cường', N'079088567890', CAST(N'2026-11-30' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (17, N'0934567890', CAST(N'1995-04-05' AS Date), N'101 Võ Văn Tần, Quận 10, TP HCM', N'Phạm Thị Dung', N'079095678901', CAST(N'2027-04-05' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (18, N'0945678901', CAST(N'1993-09-18' AS Date), N'202 Nguyễn Đình Chiểu, Quận Phú Nhuận, TP HCM', N'Hoàng Văn Em', N'079093789012', CAST(N'2027-09-18' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (19, N'0956789012', CAST(N'1991-01-25' AS Date), N'303 Cách Mạng Tháng 8, Quận Tân Bình, TP HCM', N'Vũ Thị Fương', N'079091890123', CAST(N'2026-01-25' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (20, N'0967890123', CAST(N'1994-06-10' AS Date), N'404 Điện Biên Phủ, Quận Bình Thạnh, TP HCM', N'Đặng Văn Giang', N'079094901234', CAST(N'2027-06-10' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (21, N'0978901234', CAST(N'1989-12-03' AS Date), N'505 Nguyễn Thị Minh Khai, Quận 3, TP HCM', N'Bùi Thị Hương', N'079089012345', CAST(N'2026-12-03' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (22, N'0989012345', CAST(N'1997-02-28' AS Date), N'606 Lý Tự Trọng, Quận 1, TP HCM', N'Ngô Văn Inh', N'079097123456', CAST(N'2028-02-28' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (23, N'0990123456', CAST(N'1996-08-14' AS Date), N'707 Trần Hưng Đạo, Quận 5, TP HCM', N'Dương Thị Khánh', N'079096234567', CAST(N'2027-08-14' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (24, N'0901234568', CAST(N'1993-05-20' AS Date), N'808 Nguyễn Trãi, Quận 1, TP HCM', N'Lý Văn Lâm', N'079093345678', CAST(N'2026-05-20' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (25, N'0912345679', CAST(N'1990-10-12' AS Date), N'909 Lê Duẩn, Quận 1, TP HCM', N'Mai Thị Mỹ', N'079090456789', CAST(N'2025-10-12' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (26, N'0923456780', CAST(N'1998-03-07' AS Date), N'111 Phan Xích Long, Quận Phú Nhuận, TP HCM', N'Trương Văn Nam', N'079098567890', CAST(N'2028-03-07' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (27, N'0934567891', CAST(N'1992-09-23' AS Date), N'222 Nguyễn Văn Cừ, Quận 5, TP HCM', N'Đỗ Thị Oanh', N'079092678901', CAST(N'2026-09-23' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (28, N'0945678902', CAST(N'1995-11-11' AS Date), N'333 Trường Sa, Quận 3, TP HCM', N'Hồ Văn Phúc', N'079095789012', CAST(N'2027-11-11' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (29, N'0956789013', CAST(N'1991-04-30' AS Date), N'444 Hoàng Sa, Quận 1, TP HCM', N'Lại Thị Quỳnh', N'079091890123', CAST(N'2026-04-30' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (30, N'0967890124', CAST(N'1994-07-19' AS Date), N'555 Nguyễn Công Trứ, Quận 1, TP HCM', N'Đinh Văn Rồng', N'079094901234', CAST(N'2027-07-19' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (31, N'0978901235', CAST(N'1989-01-01' AS Date), N'666 Tôn Thất Tùng, Quận 1, TP HCM', N'Chu Thị Sương', N'079089012345', CAST(N'2025-01-01' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (32, N'0989012346', CAST(N'1997-06-16' AS Date), N'777 Lý Chính Thắng, Quận 3, TP HCM', N'Lưu Văn Tùng', N'079097123456', CAST(N'2028-06-16' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (33, N'0990123457', CAST(N'1996-12-25' AS Date), N'888 Nam Kỳ Khởi Nghĩa, Quận 3, TP HCM', N'Tạ Thị Uyên', N'079096234567', CAST(N'2027-12-25' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (34, N'0901234569', CAST(N'1993-08-08' AS Date), N'999 Võ Thị Sáu, Quận 3, TP HCM', N'Phùng Văn Vinh', N'079093345678', CAST(N'2026-08-08' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (35, N'0912345670', CAST(N'1990-02-14' AS Date), N'123 Pasteur, Quận 1, TP HCM', N'Tống Thị Xuân', N'079090456789', CAST(N'2025-02-14' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (36, N'0923456781', CAST(N'1998-09-09' AS Date), N'456 Bùi Viện, Quận 1, TP HCM', N'Triệu Văn Yến', N'079098567890', CAST(N'2028-09-09' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (37, N'0934567892', CAST(N'1992-03-27' AS Date), N'789 Phạm Ngũ Lão, Quận 1, TP HCM', N'Lục Thị Zung', N'079092678901', CAST(N'2026-03-27' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (38, N'0945678903', CAST(N'1995-05-05' AS Date), N'101 Đề Thám, Quận 1, TP HCM', N'Thái Văn An', N'079095789012', CAST(N'2027-05-05' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (39, N'0956789014', CAST(N'1991-11-20' AS Date), N'202 Cô Giang, Quận 1, TP HCM', N'Mạc Thị Bảo', N'079091890123', CAST(N'2026-11-20' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (40, N'0967890125', CAST(N'1994-04-01' AS Date), N'303 Cô Bắc, Quận 1, TP HCM', N'Từ Văn Cảnh', N'079094901234', CAST(N'2027-04-01' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (41, N'0978901236', CAST(N'1989-10-10' AS Date), N'404 Nguyễn Cư Trinh, Quận 1, TP HCM', N'Công Thị Diệu', N'079089012345', CAST(N'2025-10-10' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (42, N'0989012347', CAST(N'1997-07-07' AS Date), N'505 Trần Đình Xu, Quận 1, TP HCM', N'Quách Văn Đức', N'079097123456', CAST(N'2028-07-07' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (43, N'0990123458', CAST(N'1996-01-30' AS Date), N'606 Nguyễn Thái Bình, Quận 1, TP HCM', N'Hà Thị Em', N'079096234567', CAST(N'2027-01-30' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (44, N'0901234570', CAST(N'1993-12-12' AS Date), N'707 Calmette, Quận 1, TP HCM', N'Kiều Văn Phúc', N'079093345678', CAST(N'2026-12-12' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (45, N'0912345671', CAST(N'1990-06-06' AS Date), N'808 Ký Con, Quận 1, TP HCM', N'Ninh Thị Giang', N'079090456789', CAST(N'2025-06-06' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (46, N'0923456782', CAST(N'1998-02-02' AS Date), N'909 Huyền Trân Công Chúa, Quận 1, TP HCM', N'Dương Văn Hải', N'079098567890', CAST(N'2028-02-02' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (47, N'0934567893', CAST(N'1992-08-18' AS Date), N'111 Nguyễn Thị Nghĩa, Quận 1, TP HCM', N'Đoàn Thị Inh', N'079092678901', CAST(N'2026-08-18' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (48, N'0945678904', CAST(N'1995-03-03' AS Date), N'222 Lý Văn Phức, Quận 1, TP HCM', N'Lâm Văn Khang', N'079095789012', CAST(N'2027-03-03' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (49, N'0956789015', CAST(N'1991-09-21' AS Date), N'333 Ngô Đức Kế, Quận 1, TP HCM', N'Bạch Thị Linh', N'079091890123', CAST(N'2026-09-21' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (50, N'0967890126', CAST(N'1994-05-17' AS Date), N'444 Mạc Thị Bưởi, Quận 1, TP HCM', N'Chung Văn Minh', N'079094901234', CAST(N'2027-05-17' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (51, N'0978901237', CAST(N'1989-11-11' AS Date), N'555 Hồ Tùng Mậu, Quận 1, TP HCM', N'Diệp Thị Ngọc', N'079089012345', CAST(N'2025-11-11' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (52, N'0989012348', CAST(N'1997-04-04' AS Date), N'666 Huỳnh Thúc Kháng, Quận 1, TP HCM', N'Hứa Văn Oanh', N'079097123456', CAST(N'2028-04-04' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (53, N'0990123459', CAST(N'1996-10-20' AS Date), N'777 Nguyễn Siêu, Quận 1, TP HCM', N'Khúc Thị Phương', N'079096234567', CAST(N'2027-10-20' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (54, N'0901234571', CAST(N'1993-02-28' AS Date), N'888 Tôn Thất Đạm, Quận 1, TP HCM', N'La Văn Quang', N'079093345678', CAST(N'2026-02-28' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (55, N'0912345672', CAST(N'1990-08-08' AS Date), N'999 Hải Triều, Quận 1, TP HCM', N'Mẫn Thị Rồng', N'079090456789', CAST(N'2025-08-08' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (56, N'0923456783', CAST(N'1998-01-15' AS Date), N'123 Nguyễn Văn Nguyễn, Quận 1, TP HCM', N'Nhâm Văn Sơn', N'079098567890', CAST(N'2028-01-15' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (57, N'0934567894', CAST(N'1992-07-07' AS Date), N'456 Nguyễn Thị Minh Khai, Quận 3, TP HCM', N'Ông Thị Tâm', N'079092678901', CAST(N'2026-07-07' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (58, N'0945678905', CAST(N'1995-12-25' AS Date), N'789 Cao Thắng, Quận 3, TP HCM', N'Phan Văn Uy', N'079095789012', CAST(N'2027-12-25' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (59, N'0956789016', CAST(N'1991-06-30' AS Date), N'101 Võ Văn Tần, Quận 3, TP HCM', N'Quang Thị Vân', N'079091890123', CAST(N'2026-06-30' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (60, N'0967890127', CAST(N'1994-03-17' AS Date), N'202 Trần Quốc Thảo, Quận 3, TP HCM', N'Thân Văn Xuân', N'079094901234', CAST(N'2027-03-17' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (61, N'0978901238', CAST(N'1989-09-09' AS Date), N'303 Nguyễn Thượng Hiền, Quận 3, TP HCM', N'Uông Thị Yến', N'079089012345', CAST(N'2025-09-09' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (62, N'0989012349', CAST(N'1997-05-05' AS Date), N'404 Lê Văn Sỹ, Quận 3, TP HCM', N'Vương Văn Zũng', N'079097123456', CAST(N'2028-05-05' AS Date), 20, 0)
INSERT [dbo].[NGUOI_DOC] ([id], [sdt], [ngaySinh], [diaChi], [hoTen], [CCCD], [hanSuDung], [soLuongMuonChoPhep], [trangThaiViPham]) VALUES (63, N'0990123460', CAST(N'1996-11-23' AS Date), N'505 Trần Quang Diệu, Quận 3, TP HCM', N'Xung Thị Ánh', N'079096234567', CAST(N'2027-11-23' AS Date), 20, 0)
GO
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (1, N'Nhã Nam', N'Số 81 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội', N'024 3822 0801  ', N'veph@nxbgd.vn')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (2, N'Kim Đồng', N'55 Quang Trung, Hai Bà Trưng, Hà Nội', N'1900571595     ', N'info@nxbkimdong.com.vn')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (3, N'Trẻ', N'161B Lý Chính Thắng, Phường Võ Thị Sáu, Quận 3 , TP. Hồ Chí Minh', N'028 3931 6289  ', N'hopthubandoc@nxbtre.com.vn')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (7, N'Nhà Xuất Bản Đinh Tị', N'NV22, Lĩnh Nam, Hoàng Mai, Hà Nội', N'0247 309 3388  ', N'contact@dinhtibooks.com.vn')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (8, N'Nhà Xuất Bản Đông A', N'34 Hàng Bài, Hoàn Kiếm, Hà Nội', N'024 3942 4567  ', N'info@donga.com.vn')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (9, N'Nhà Xuất Bản Văn Học', N'Hà Nội', N'024 3942 4567  ', N'info@nxbvanhoc.vn')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (10, N'Nhà Xuất Bản Hội Nhà Văn', N'Hà Nội', N'024 3943 4567  ', N'contact@hoinhavan.com')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (11, N'Penguin Random House', N'New York, USA', N'2123662000     ', N'contact@penguinrandomhouse.com')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (12, N'HarperCollins', N'New York, USA', N'2122077000     ', N'feedback@harpercollins.com')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (13, N'Simon & Schuster', N'New York, USA', N'2126987000     ', N'contact@simonandschuster.com')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (14, N'Macmillan Publishers', N'New York, USA', N'6463075151     ', N'info@macmillan.com')
INSERT [dbo].[NHA_XUAT_BAN] ([id], [ten], [diaChi], [sdt], [email]) VALUES (15, N'Hachette Book Group', N'New York, USA', N'2123641100     ', N'contact@hachettebookgroup.com')
GO
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (1, N'Thuỳ Trang xinh đẹp', N'2002-12-16', N'273 An Dương Vương, phường 10, quận 5, TP HCM', N'060504789258', 1, N'123456')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (2, N'Minh Quang', N'2003-04-23', N'4 Tôn Đức Thắng, phường 5, quận 1, TP HCM', N'090807963258', 0, N'654321')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (4, N'Nguyễn Văn An', N'1985-02-14', N'123 Lê Lợi, Quận 1, TP HCM', N'123456789456', 1, N'matkhau123')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (5, N'Lê Thị Hồng', N'1990-06-25', N'456 Trần Hưng Đạo, Quận 5, TP HCM', N'987654321845', 0, N'lethihong90')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (6, N'Trần Quang Minh', N'1995-08-10', N'789 Nguyễn Đình Chiểu, Quận 3, TP HCM', N'456789123259', 1, N'minhtrannguyen')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (7, N'Hoàng Thu Trang', N'1988-11-22', N'101 Cách Mạng Tháng 8, Quận 10, TP HCM', N'321654987459', 0, N'tranghoang88')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (8, N'Phạm Văn Bảo', N'1993-03-18', N'202 Phan Xích Long, Quận Phú Nhuận, TP HCM', N'654852357045', 1, N'baopham93')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (9, N'Nguyễn Thị Mai', N'1990-05-15', N'25 Nguyễn Huệ, Quận 1, TP HCM', N'123456789012', 0, N'mai1990')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (10, N'Trần Văn Hùng', N'1988-09-22', N'78 Lê Lai, Quận 3, TP HCM', N'234567890123', 0, N'hung1988')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (11, N'Lê Thị Hương', N'1995-03-10', N'56 Võ Văn Tần, Quận 10, TP HCM', N'345678901234', 0, N'huong1995')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (12, N'Phạm Minh Tuấn', N'1992-11-30', N'89 Nguyễn Đình Chiểu, Quận 5, TP HCM', N'456789012345', 0, N'tuan1992')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (13, N'Hoàng Thị Lan', N'1987-07-18', N'123 Cách Mạng Tháng 8, Quận Tân Bình, TP HCM', N'567890123456', 0, N'lan1987')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (14, N'Vũ Đức Thắng', N'1993-02-25', N'45 Trần Quốc Thảo, Quận 3, TP HCM', N'678901234567', 0, N'thang1993')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (15, N'Đặng Thu Hà', N'1991-08-05', N'67 Lý Tự Trọng, Quận 1, TP HCM', N'789012345678', 0, N'ha1991')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (16, N'Bùi Quang Huy', N'1989-12-12', N'34 Nguyễn Thị Minh Khai, Quận 3, TP HCM', N'890123456789', 0, N'huy1989')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (17, N'Ngô Thị Thanh', N'1994-06-20', N'90 Điện Biên Phủ, Quận Bình Thạnh, TP HCM', N'901234567890', 0, N'thanh1994')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (18, N'Đỗ Văn Nam', N'1986-04-08', N'12 Hai Bà Trưng, Quận 1, TP HCM', N'012345678901', 0, N'nam1986')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (19, N'Lý Thị Hồng', N'1997-01-15', N'78 Nguyễn Trãi, Quận 5, TP HCM', N'123987456321', 0, N'hong1997')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (20, N'Trương Minh Đức', N'1990-09-28', N'56 Lê Duẩn, Quận 1, TP HCM', N'234098765432', 0, N'duc1990')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (21, N'Mai Thị Linh', N'1993-05-07', N'89 Phạm Ngũ Lão, Quận 1, TP HCM', N'345109876543', 0, N'linh1993')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (22, N'Hồ Quốc Việt', N'1988-11-11', N'23 Nguyễn Công Trứ, Quận 1, TP HCM', N'456210987654', 0, N'viet1988')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (23, N'Phan Thị Ngọc', N'1995-07-30', N'45 Trần Hưng Đạo, Quận 5, TP HCM', N'567321098765', 0, N'ngoc1995')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (24, N'Đinh Văn Long', N'1992-03-22', N'67 Lý Thường Kiệt, Quận 10, TP HCM', N'678432109876', 0, N'long1992')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (25, N'Chu Thị Mai', N'1989-10-05', N'90 Nguyễn Thái Học, Quận 1, TP HCM', N'789543210987', 0, N'mai1989')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (26, N'Lương Văn Bình', N'1994-08-18', N'12 Võ Thị Sáu, Quận 3, TP HCM', N'890654321098', 0, N'binh1994')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (27, N'Dương Thị Hà', N'1991-02-28', N'34 Bà Huyện Thanh Quan, Quận 3, TP HCM', N'901765432109', 0, N'ha1991')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (28, N'Tạ Văn Dũng', N'1987-06-14', N'56 Nguyễn Văn Cừ, Quận 5, TP HCM', N'012876543210', 0, N'dung1987')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (29, N'Võ Thị Thúy', N'1996-04-25', N'78 Cao Thắng, Quận 3, TP HCM', N'123098765432', 0, N'thuy1996')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (30, N'Đoàn Minh Tuấn', N'1993-12-08', N'90 Lê Thánh Tôn, Quận 1, TP HCM', N'234109876543', 0, N'tuan1993')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (31, N'Hứa Thị Lan', N'1990-08-20', N'12 Nguyễn Du, Quận 1, TP HCM', N'345210987654', 0, N'lan1990')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (32, N'Kiều Văn Hải', N'1988-01-30', N'34 Trần Quang Khải, Quận 1, TP HCM', N'456321098765', 0, N'hai1988')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (33, N'Lâm Thị Hương', N'1995-09-12', N'56 Phó Đức Chính, Quận 1, TP HCM', N'567432109876', 0, N'huong1995')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (34, N'Triệu Văn Phong', N'1992-05-05', N'78 Nguyễn Cư Trinh, Quận 1, TP HCM', N'678543210987', 0, N'phong1992')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (35, N'Quách Thị Thảo', N'1989-03-17', N'90 Calmette, Quận 1, TP HCM', N'789654321098', 0, N'thao1989')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (36, N'Tô Văn Hoàng', N'1994-11-23', N'12 Lý Chính Thắng, Quận 3, TP HCM', N'890765432109', 0, N'hoang1994')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (37, N'Mạc Thị Dung', N'1991-07-07', N'34 Trần Cao Vân, Quận 3, TP HCM', N'901876543210', 0, N'dung1991')
INSERT [dbo].[NHAN_VIEN] ([id], [hoTen], [ngaySinh], [diaChi], [CCCD], [vaiTro], [matKhau]) VALUES (38, N'Thái Văn Thành', N'1986-10-10', N'56 Nguyễn Thiện Thuật, Quận 3, TP HCM', N'012987654321', 0, N'thanh1986')
GO
INSERT [dbo].[PHIEU_MUON] ([id], [idNhanVien], [idNguoiDoc], [ngayMuon], [ngayTra]) VALUES (1, 1, 1, CAST(N'2024-05-07' AS Date), CAST(N'2024-05-22' AS Date))
INSERT [dbo].[PHIEU_MUON] ([id], [idNhanVien], [idNguoiDoc], [ngayMuon], [ngayTra]) VALUES (2, 1, 2, CAST(N'2024-05-07' AS Date), CAST(N'2024-05-22' AS Date))
INSERT [dbo].[PHIEU_MUON] ([id], [idNhanVien], [idNguoiDoc], [ngayMuon], [ngayTra]) VALUES (3, 2, 3, CAST(N'2024-05-07' AS Date), CAST(N'2024-05-22' AS Date))
INSERT [dbo].[PHIEU_MUON] ([id], [idNhanVien], [idNguoiDoc], [ngayMuon], [ngayTra]) VALUES (4, 1, 2, CAST(N'2024-09-11' AS Date), CAST(N'2024-09-26' AS Date))
INSERT [dbo].[PHIEU_MUON] ([id], [idNhanVien], [idNguoiDoc], [ngayMuon], [ngayTra]) VALUES (5, 1, 1, CAST(N'2024-09-13' AS Date), CAST(N'2024-09-28' AS Date))
GO
INSERT [dbo].[PHIEU_TRA] ([id], [idNguoiDoc], [ngayTraThatSu], [tienPhat]) VALUES (1, 1, CAST(N'2024-05-07' AS Date), 0.0000)
INSERT [dbo].[PHIEU_TRA] ([id], [idNguoiDoc], [ngayTraThatSu], [tienPhat]) VALUES (2, 2, CAST(N'2024-05-07' AS Date), 0.0000)
INSERT [dbo].[PHIEU_TRA] ([id], [idNguoiDoc], [ngayTraThatSu], [tienPhat]) VALUES (3, 2, CAST(N'2024-05-07' AS Date), 6500.0000)
INSERT [dbo].[PHIEU_TRA] ([id], [idNguoiDoc], [ngayTraThatSu], [tienPhat]) VALUES (4, 2, CAST(N'2024-09-11' AS Date), 62000.0000)
GO
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (1, N'Cho Tôi Xin Một Vé Đi Tuổi Thơ  ', 62000.0000, 15, 0, 1, 3, 7)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (2, N'Ngồi Khóc Trên Cây', 85000.0000, 6, 0, 1, 3, 7)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (3, N'Thiên Thần Nhỏ Của Tôi  ', 57000.0000, 5, 0, 1, 3, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (6, N'Robin Hood: Hiệp Sĩ Rừng Xanh  ', 69000.0000, 42, 0, 2, 2, 11)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (7, N'Chuyện Con Mèo Dạy Hải Âu Bay', 54000.0000, 58, 0, 3, 2, 12)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (8, N'Clean Code - A Handbook of Agile Software Craftsmanship', 1800000.0000, 3, 0, 3, 1, 5)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (9, N'Truyện Kiều', 100000.0000, 15, 0, 13, 9, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (10, N'Lục Vân Tiên', 90000.0000, 12, 0, 14, 9, 13)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (11, N'Tắt Đèn', 85000.0000, 10, 0, 15, 10, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (12, N'Chí Phèo', 75000.0000, 8, 0, 16, 10, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (13, N'Số Đỏ', 95000.0000, 20, 0, 6, 3, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (14, N'Nỗi Buồn Chiến Tranh', 120000.0000, 25, 0, 5, 2, 15)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (15, N'Mùa Hoa Cải', 68000.0000, 5, 0, 19, 3, 15)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (29, N'Trên Đường Băng', 95000.0000, 20, 0, 14, 9, 17)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (32, N'Những Ngày Thơ Ấu', 68000.0000, 15, 0, 19, 9, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (34, N'Những Người Khốn Khổ', 120000.0000, 5, 0, 5, 10, 15)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (35, N'Không Gia Đình', 86000.0000, 17, 0, 19, 2, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (36, N'Những Ngọn Núi Hát', 99000.0000, 7, 0, 5, 9, 3)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (37, N'Hoa Vàng Trên Cỏ Xanh', 90000.0000, 9, 0, 14, 3, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (38, N'Dế Mèn Phiêu Lưu Ký', 87000.0000, 14, 0, 7, 9, 7)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (39, N'1984', 150000.0000, 20, 0, 23, 11, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (40, N'To Kill a Mockingbird', 140000.0000, 15, 0, 26, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (41, N'The Great Gatsby', 130000.0000, 18, 0, 27, 13, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (42, N'Pride and Prejudice', 120000.0000, 22, 0, 26, 11, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (43, N'The Catcher in the Rye', 135000.0000, 17, 0, 25, 12, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (44, N'Harry Potter and the Philosopher''s Stone', 180000.0000, 30, 0, 24, 11, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (45, N'The Hobbit', 160000.0000, 25, 0, 23, 13, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (46, N'Brave New World', 145000.0000, 19, 0, 22, 12, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (47, N'The Lord of the Rings', 250000.0000, 15, 0, 23, 11, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (48, N'Crime and Punishment', 170000.0000, 12, 0, 28, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (49, N'One Hundred Years of Solitude', 190000.0000, 20, 0, 21, 13, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (50, N'Animal Farm', 125000.0000, 28, 0, 23, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (51, N'The Old Man and the Sea', 110000.0000, 23, 0, 25, 11, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (52, N'The Wind-Up Bird Chronicle', 180000.0000, 16, 0, 20, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (53, N'Norwegian Wood', 160000.0000, 18, 0, 20, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (54, N'Jane Eyre', 140000.0000, 21, 0, 22, 11, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (55, N'Wuthering Heights', 130000.0000, 19, 0, 22, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (56, N'The Picture of Dorian Gray', 150000.0000, 17, 0, 22, 13, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (57, N'The Adventures of Huckleberry Finn', 125000.0000, 24, 0, 30, 14, 11)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (58, N'Alice''s Adventures in Wonderland', 115000.0000, 26, 0, 29, 11, 7)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (59, N'The Brothers Karamazov', 200000.0000, 14, 0, 28, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (60, N'War and Peace', 280000.0000, 10, 0, 28, 13, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (61, N'Moby-Dick', 170000.0000, 16, 0, 25, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (62, N'The Grapes of Wrath', 160000.0000, 18, 0, 27, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (63, N'Frankenstein', 140000.0000, 20, 0, 22, 11, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (64, N'The Odyssey', 150000.0000, 15, 0, 26, 12, 11)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (65, N'The Iliad', 150000.0000, 15, 0, 26, 12, 11)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (66, N'Don Quixote', 180000.0000, 12, 0, 21, 13, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (67, N'Madame Bovary', 145000.0000, 17, 0, 22, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (68, N'The Divine Comedy', 190000.0000, 13, 0, 29, 15, 13)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (69, N'Lolita', 155000.0000, 16, 0, 20, 11, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (70, N'The Sound and the Fury', 165000.0000, 14, 0, 27, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (71, N'Middlemarch', 175000.0000, 15, 0, 26, 13, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (72, N'Things Fall Apart', 135000.0000, 22, 0, 21, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (73, N'The Stranger', 130000.0000, 20, 0, 25, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (74, N'Beloved', 155000.0000, 18, 0, 24, 11, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (75, N'Mrs. Dalloway', 140000.0000, 19, 0, 22, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (76, N'The Metamorphosis', 120000.0000, 25, 0, 23, 13, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (77, N'Heart of Darkness', 125000.0000, 21, 0, 29, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (78, N'The Portrait of a Lady', 160000.0000, 16, 0, 26, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (79, N'The Trial', 145000.0000, 18, 0, 23, 11, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (80, N'The Handmaid''s Tale', 170000.0000, 20, 0, 24, 12, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (81, N'A Tale of Two Cities', 155000.0000, 19, 0, 29, 13, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (82, N'Lord of the Flies', 135000.0000, 23, 0, 23, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (83, N'The Sun Also Rises', 140000.0000, 21, 0, 25, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (84, N'The Count of Monte Cristo', 200000.0000, 15, 0, 2, 11, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (85, N'Anna Karenina', 190000.0000, 16, 0, 28, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (86, N'The Scarlet Letter', 130000.0000, 22, 0, 26, 13, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (87, N'Ulysses', 210000.0000, 12, 0, 22, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (88, N'Slaughterhouse-Five', 150000.0000, 20, 0, 25, 15, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (89, N'The Great Expectations', 145000.0000, 21, 0, 29, 11, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (90, N'One Flew Over the Cuckoo''s Nest', 160000.0000, 18, 0, 24, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (91, N'Fahrenheit 451', 140000.0000, 24, 0, 23, 13, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (92, N'The Alchemist', 130000.0000, 25, 0, 21, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (93, N'The Little Prince', 110000.0000, 30, 0, 25, 15, 7)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (94, N'The Hunger Games', 170000.0000, 28, 0, 24, 11, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (95, N'The Da Vinci Code', 165000.0000, 26, 0, 24, 12, 3)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (96, N'The Girl with the Dragon Tattoo', 175000.0000, 22, 0, 20, 13, 3)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (97, N'The Help', 155000.0000, 24, 0, 26, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (98, N'The Kite Runner', 150000.0000, 23, 0, 21, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (99, N'The Road', 145000.0000, 20, 0, 25, 11, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (100, N'Gone Girl', 160000.0000, 25, 0, 24, 12, 3)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (101, N'The Fault in Our Stars', 135000.0000, 27, 0, 24, 13, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (102, N'The Book Thief', 155000.0000, 22, 0, 23, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (103, N'The Giver', 125000.0000, 26, 0, 24, 15, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (104, N'The Maze Runner', 145000.0000, 28, 0, 24, 11, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (105, N'The Martian', 170000.0000, 23, 0, 23, 12, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (106, N'Ready Player One', 165000.0000, 24, 0, 24, 13, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (107, N'The Night Circus', 160000.0000, 21, 0, 22, 14, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (108, N'The Goldfinch', 185000.0000, 19, 0, 26, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (109, N'The Catcher in the Rye', 140000.0000, 25, 0, 27, 11, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (110, N'The Pillars of the Earth', 220000.0000, 17, 0, 28, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (111, N'The Name of the Wind', 180000.0000, 20, 0, 24, 13, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (112, N'The Shadow of the Wind', 170000.0000, 22, 0, 21, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (113, N'The Nightingale', 165000.0000, 23, 0, 26, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (114, N'The Hitchhiker''s Guide to the Galaxy', 145000.0000, 26, 0, 23, 11, 6)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (115, N'The Clan of the Cave Bear', 175000.0000, 18, 0, 22, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (116, N'The Silence of the Lambs', 160000.0000, 21, 0, 24, 13, 3)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (117, N'The Color Purple', 150000.0000, 24, 0, 26, 14, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (118, N'The Poisonwood Bible', 170000.0000, 20, 0, 26, 15, 14)
GO
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (119, N'The Time Traveler''s Wife', 155000.0000, 23, 0, 22, 11, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (120, N'The Lovely Bones', 145000.0000, 25, 0, 24, 12, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (121, N'The Curious Incident of the Dog in the Night-Time', 135000.0000, 27, 0, 23, 13, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (122, N'The Girl on the Train', 155000.0000, 24, 0, 24, 14, 3)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (123, N'The Guernsey Literary and Potato Peel Pie Society', 150000.0000, 22, 0, 26, 15, 14)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (124, N'The Perks of Being a Wallflower', 130000.0000, 26, 0, 24, 11, 10)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (125, N'The Glass Castle', 160000.0000, 21, 0, 26, 12, 18)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (126, N'The Immortal Life of Henrietta Lacks', 175000.0000, 19, 0, 25, 13, 15)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (127, N'The Devil in the White City', 165000.0000, 20, 0, 25, 14, 15)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (128, N'The Power of Habit', 155000.0000, 23, 0, 24, 15, 19)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (129, N'The 7 Habits of Highly Effective People', 180000.0000, 25, 0, 24, 11, 19)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (130, N'Sapiens: A Brief History of Humankind', 200000.0000, 18, 0, 23, 12, 15)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (131, N'The Tipping Point', 150000.0000, 22, 0, 24, 13, 20)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (132, N'Freakonomics', 145000.0000, 24, 0, 25, 14, 20)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (133, N'Thinking, Fast and Slow', 185000.0000, 20, 0, 23, 15, 22)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (134, N'The Art of War', 120000.0000, 28, 0, 29, 11, 21)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (135, N'The Prince', 125000.0000, 26, 0, 29, 12, 21)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (136, N'The Republic', 140000.0000, 23, 0, 29, 13, 22)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (137, N'Meditations', 130000.0000, 25, 0, 29, 14, 22)
INSERT [dbo].[SACH] ([id], [tenSach], [giaSach], [soLuong], [trangThai], [idTacGia], [idNhaXuatBan], [idLoaiSach]) VALUES (138, N'The Last Lecture', 140000.0000, 24, 0, 25, 15, 18)
GO
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (1, N'Nguyễn Nhật Ánh')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (2, N'Alexandre Dumas')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (3, N'Luis Sepúlveda')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (5, N'Nguyễn Huy Thiệp')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (6, N'Bảo Ninh')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (7, N'Tô Hoài')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (8, N'Trần Đăng Khoa')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (9, N'Nguyễn Khải')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (13, N'Nguyễn Du')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (14, N'Ngô Tất Tố')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (15, N'Nam Cao')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (16, N'Vũ Trọng Phụng')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (19, N'Lê Minh Khuê')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (20, N'Haruki Murakami')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (21, N'Gabriel García Márquez')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (22, N'Virginia Woolf')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (23, N'George Orwell')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (24, N'J.K. Rowling')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (25, N'Ernest Hemingway')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (26, N'Jane Austen')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (27, N'F. Scott Fitzgerald')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (28, N'Leo Tolstoy')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (29, N'Charles Dickens')
INSERT [dbo].[TAC_GIA] ([id], [hoTen]) VALUES (30, N'Mark Twain')
GO
ALTER TABLE [dbo].[CT_PHIEU_MUON]  WITH CHECK ADD FOREIGN KEY([idPhieuMuon])
REFERENCES [dbo].[PHIEU_MUON] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CT_PHIEU_MUON]  WITH CHECK ADD FOREIGN KEY([idSach])
REFERENCES [dbo].[SACH] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CT_PHIEU_TRA]  WITH CHECK ADD FOREIGN KEY([idPhieuTra])
REFERENCES [dbo].[PHIEU_TRA] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CT_PHIEU_TRA]  WITH CHECK ADD FOREIGN KEY([idSach])
REFERENCES [dbo].[SACH] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PHIEU_MUON]  WITH CHECK ADD FOREIGN KEY([idNguoiDoc])
REFERENCES [dbo].[NGUOI_DOC] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PHIEU_MUON]  WITH CHECK ADD FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NHAN_VIEN] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PHIEU_TRA]  WITH CHECK ADD FOREIGN KEY([idNguoiDoc])
REFERENCES [dbo].[NGUOI_DOC] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SACH]  WITH CHECK ADD FOREIGN KEY([idLoaiSach])
REFERENCES [dbo].[LOAI_SACH] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SACH]  WITH CHECK ADD FOREIGN KEY([idNhaXuatBan])
REFERENCES [dbo].[NHA_XUAT_BAN] ([id])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SACH]  WITH CHECK ADD FOREIGN KEY([idTacGia])
REFERENCES [dbo].[TAC_GIA] ([id])
ON DELETE CASCADE
GO
USE [master]
GO
ALTER DATABASE [QuanLyThuVien] SET  READ_WRITE 
GO
